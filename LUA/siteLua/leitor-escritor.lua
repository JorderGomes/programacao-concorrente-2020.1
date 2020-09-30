function receive (prod)
    -- Indica que o escritor está livre para realizar uma escrita de dado
    local status, value = coroutine.resume(prod)
    return value
  end
   
  function send (x)
    -- Liberação de acesso ao dado
    coroutine.yield(x)
  end
   
  function writer ()
    return coroutine.create(function ()
      for i=1, 20 do
        local x = {}     -- declaração de um vetor que servirá de base para consumo
        x[i] = i * math.random(1,4) -- Adicionando um valor aleatorio à posição atual do vetor
        send(x)
      end
    end)
  end
   
  function filter (prod)
    return coroutine.create(function ()
      local line = 1
      for i=1, 20 do
        local x = receive(prod)   -- Receber o novo valor
        x = string.format("line: %2d | value: %3s |", line, x[i])    -- Organização da saída na tela
        send(x)      -- Envio do valor para leitura
        line = line + 1
      end
    end)
  end
   
  function reader (prod, num)
    local x = receive(prod)   -- Receber o valor
    io.write(x, "  reader:" ,num, "\n")    -- Realizar leitura do valor
  end
   
  math.randomseed(os.time())    --Adicionar uma seed baseada no tempo da máquina para deixar aleátorio
  p = writer()    -- Instanciando o Escritor
  f = filter(p)    -- Instanciando o Filtro (serve como interface de comunicação entre Escritor e Leitor)
  local readerA = 0
  local readerB = 0
  for i=1, 20 do
    -- Sorteio para ver qual leitor realizará a leitra do dado
    if (math.random(1,2) == 1) then
      reader(f, 1)
      readerA = readerA + 1
    else
      reader(f, 2)
      readerB = readerB + 1
    end
  end
   
  io.write("Times used from: readerA ", readerA, ", readerB ", readerB, "\n")