function receive (prod)
  local status, value = coroutine.resume(prod)
  return value
end

function send (x)
  coroutine.yield(x)
end

function producer ()
  return coroutine.create(function ()
    local num = 0 --não utilize esta linha caso queira usar a entrada de um usuário.
    while true do

    --Para usar um exemplo onde o dado de entrada é fornecido pelo usuário, use a linha a seguir:
    --local x = io.read()     -- recebe um dado que o usuário digita.

      cont = cont + 1 --incrementa o valor do contador.
      local x = cont  --passa o valor para X e então envia para a função de envio.
      send(x)
    end
  end)
end

function filter (prod)
  return coroutine.create(function ()
    local line = 1
    while true do
      local x = receive(prod)   -- get new value
      x = string.format("%5d %s", line, x)
      send(x)      -- send it to consumer
      line = line + 1
    end
  end)
end

function consumer (prod)
  while true do
    local x = receive(prod)   -- get new value
    io.write(x, "\n")          -- consume new value
  end
end

--Para executar o código:
p = producer()
f = filter(p)
consumer(f)