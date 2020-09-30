co = coroutine.create(function (a,b)
    coroutine.yield(a + b, a - b, a / b, a * b)
end)

  print('Digite um valor ')
  a = io.read()
  print('Digite outro valor ')
  b = io.read()

print(coroutine.resume(co, a, b))  