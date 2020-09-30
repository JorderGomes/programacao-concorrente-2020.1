soma = 0
array = {1, 2, 3, 4, 5}
size = #array
co = coroutine.wrap(
    function (array, soma)
        for i = 1, size, 1 do
            soma = soma + array[i]
        end
        print(soma)
        
    end
)

co(array, soma)


-- coroutine.resume(co, array, soma)

-- coroutine.resume(co, array, soma)

