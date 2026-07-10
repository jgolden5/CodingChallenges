def is_palindrome(s):
  print(f"Input = {s}")
  lowercase_s = s.lower()
  first_half = ""
  second_half = ""
  midpoint = len(lowercase_s) / 2
  for i in range(midpoint):
    if i < len(lowercase_s) / 2:
      first_half += c
    elif i == len(lowercase_s) / 2:
      first_half += c
      second_half = c
    else:
      second_half = c + second_half
  return first_half == second_half

if __name__ == "__main__":
  print(is_palindrome("123"))
  print(is_palindrome("racecar"))
  print(is_palindrome("Jonathan"))