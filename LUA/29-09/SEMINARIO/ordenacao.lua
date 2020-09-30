vetorDesordenado = {5, 4, 3, 2, 1}

function countLowerNumbers(vetor, valor)
    local count = 0
    for j = 1, #vetor, 1 do 
        if vetor[j] <= valor
        then
            count = count + 1
        end
    end    
    return count
end

ordenar = coroutine.create(
    function (vetorDesordenado)
        vetorOrdenado = {0, 0, 0, 0, 0}
        for i = 1, #vetorDesordenado, 1 do 
            local j = countLowerNumbers(vetorDesordenado, vetorDesordenado[i])
            vetorOrdenado[j] = vetorDesordenado[i]
        end
        print("Vetor desordenado")
        for i = 1, #vetorDesordenado, 1 do 
            print(vetorDesordenado[i])
        end
        print("Vetor ordenado")
        for i = 1, #vetorOrdenado, 1 do 
            print(vetorOrdenado[i])
        end
    end
)



coroutine.resume(ordenar, vetorDesordenado)
    
