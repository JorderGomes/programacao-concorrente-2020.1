co1 = coroutine.create(function ()
    local i = 1
    while i < 200 do
            print("nooo")
            i = i + 1
    end
    coroutine.yield()
end)

co2 = coroutine.create(function ()
    local i = 1
    while i < 200 do
            print("yaaaay")
            i = i + 1
    end
    coroutine.yield()
end)

coroutine.resume(co1)
coroutine.resume(co2)