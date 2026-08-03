Words = {}
Words['a'] = 1
Words['b'] = 2
Words['c'] = 3
Words['d'] = 4
Words['e'] = 5
Words['f'] = 6
Words['g'] = 7
Words['h'] = 8
Words['i'] = 9
Words['j'] = 10
Words['k'] = 11
Words['l'] = 12
Words['m'] = 13
Words['n'] = 14
Words['o'] = 15
Words['p'] = 16
Words['q'] = 17
Words['r'] = 18
Words['s'] = 19
Words['t'] = 20
Words['u'] = 21
Words['v'] = 22
Words['w'] = 23
Words['x'] = 24
Words['y'] = 25
Words['z'] = 26

function word_sum(str)
  local sum = 0
  for i = 1, #str do
    local char = str:sub(i, i)
    local val = Words[char]
    sum = sum + val
  end
  return sum
end

print(word_sum("blah"))
print(word_sum("love"))
print(word_sum("friendship"))

--solved in 23 minutes (7 kyu)
