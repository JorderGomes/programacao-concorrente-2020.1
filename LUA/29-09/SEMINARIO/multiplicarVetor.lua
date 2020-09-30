array = {1, 2, 3, 4, 5}
array2 = {1, 2, 3, 4, 5}
array3 = {}

size = #array
co = coroutine.wrap(
    function (array, array2, array3)
        for i = 1, size, 1 do
            array3[i] = array[i] * array2[i]
        end
        for i = 1, size, 1 do
            print(array3[i])
        end 
    end
)

co(array, array2, array3)

