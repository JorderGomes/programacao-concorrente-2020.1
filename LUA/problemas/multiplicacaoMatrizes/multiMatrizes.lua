qtdLinhasA = 0
qtdColunasA = 0
qtdLinhasB = 0
qtdColunasB = 0



function fabricaMatrizes (linhas, colunas, numero)
    matrizProduto = {}
    for i=1, linhas, 1 do
        matrizProduto[i] = {} -- nova linha
        for j=1, colunas, 1 do
        matrizProduto[i][j] = math.random(numero) - 1
       end
       end
    showMatriz(matrizProduto, linhas, colunas)
    return matrizProduto
end



function showMatriz(matriz, linhas, colunas)
    for i = 1, linhas, 1 do
        for j = 1, colunas, 1 do
            print(matriz[i][j])
        end
    end
end



trabalhador = coroutine.create(
        function (matrizResultante, matrizA, matrizB, i, j, k)
            matrizResultante[i][j] = matrizA[i][k] * matrizB[k][j] 
        end
    )

function multiplicacaoMatrizes (matrizResultante, matrizA, matrizB, nlinhas, ncolunas)
    for i = 0, nlinhas, 1 do
        for j = 0, ncolunas, 1 do 
            for k = 0, nlinhas, i do
            coroutine.resume(trabalhador, matrizResultante, matrizA, matrizB, i, j, k)
            end
        end
    end
    
    showMatriz(matrizResultante, nlinhas, ncolunas);
end

function main()
    print('Digite a quantidade de linhas da matrizA ')
    qtdLinhasA = io.read()
    print('Digite a quantidade de colunas da matrizA ')
    qtdColunasA = io.read()
    print('Digite a quantidade de linhas da matrizB ')
    qtdLinhasB = io.read()
    print('Digite a quantidade de colunas da matrizB ')
    qtdColunasB = io.read()
    print("\n")
    print('criação da matriz A')
    matrizA = fabricaMatrizes(qtdLinhasA, qtdColunasA, 10)
    print('criação da matriz B')
    matrizB = fabricaMatrizes(qtdLinhasB, qtdColunasB, 10)
    print('criação da matriz resultante')
    MatrizResultante = fabricaMatrizes(qtdLinhasA, qtdColunasB, 1)
    multiplicacaoMatrizes(MatrizResultante, matrizA, matrizB, qtdLinhasA, qtdColunasB)
    print('resultado final')
    showMatriz(MatrizResultante, qtdLinhasA, qtdColunasB)
end


main()

