function main ()
    
    p1 = generateProcess(0, 3)
    p2 = generateProcess(2, 6)
    p3 = generateProcess(4, 4)
    p4 = generateProcess(6, 2)
    listp = {p1, p2, p3, p4}
    for processos = 1, 4, 1 do
        
        if 
            print(listp[processos])
        end
    end
end



function generateProcess()
    thread = coroutine.create(
        function(chegada, servico)
            -- while servico ~= 0 do
            --     servico = servico - 1
            -- end
        end
    )
    return thread;
end

main()