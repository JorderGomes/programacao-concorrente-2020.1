local h = "hint"--Instance.new("Hint", workspace);
local m = "message"-- Instance.new("Message", workspace);
 
local changeHint = coroutine.wrap(function()
    for i = 60, 0, -1 do
--       wait(0.5)
       h = i
       print(h)
       coroutine.yield()
    end
end)
local changeMessage = coroutine.wrap(function()
    for i = 60, 0, -1 do
        --wait(1)
        m = i
        print(m)
        coroutine.yield()
    end
end)

i = 0
while i <= 60 do 
    changeHint()
    changeMessage()
    i = i + 1
end