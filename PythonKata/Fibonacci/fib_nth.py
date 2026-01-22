#Parameters
  #n (which digit of the fibonacci sequence is desired) >= 1
  #What will the maximum number be? Looks like the highest value in the test cases is just over 10,000
#R
  #return the nth digit of the fibonacci sequence, where the sequence begins: 0, 1, 1, 2, 3, 5, 8, etc, where each number is the sum of the last 2 digits, and the first 2 numbers are 0 and 1
#E
  #fib_nth(0) -> 0
  #fib_nth(1) -> 1
  #fib_nth(2) -> 1
  #fib_nth(3) -> 2
  #fib_nth(4) -> 3
  #fib_nth(5) -> 5
  #fib_nth(6) -> 8
  #fib_nth(7) -> 13
  #fib_nth(8) -> 21
  #fib_nth(9) -> 34
  #fib_nth(10)-> 55
#P
  #set

def fib_nth(n):
  first = 0
  second = 1
  if n > 1:
    for i in range(n - 1):
      og_second = second
      second = first + second
      first = og_second
    return first
  elif n == 2:
    return second
  else:
    return first

print("1:", fib_nth(1)) #0
print("2:", fib_nth(2)) #1
print("3:", fib_nth(3)) #1
print("4:", fib_nth(4)) #2
print("5:", fib_nth(5)) #3
print("6:", fib_nth(6)) #5
print("7:", fib_nth(7)) #8
print("8:", fib_nth(8)) #13
print("9:", fib_nth(9)) #21
print("10:", fib_nth(10)) #34
