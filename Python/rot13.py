def rot13(message):
  rot13_message = ""
  for c in message:
    char_code = ord(c)
    if char_code > 64 and char_code < 91 or char_code > 96 and char_code < 123:
      is_lower = c.islower()
      char_pos = get_char_position_in_alphabet(c, is_lower)
      rot13_char_pos = get_rot13_char_position_in_alphabet_given_position(char_pos)
      rot13_char = get_char_given_position(rot13_char_pos, is_lower)
      rot13_message += rot13_char
    else:
      rot13_message += c
  return rot13_message

def get_char_position_in_alphabet(c, is_lower):
  if is_lower:
    return ord(c) - 96
  else:
    return ord(c) - 64

def get_rot13_char_position_in_alphabet_given_position(start_pos):
  res = (start_pos + 13) % 26
  return res if res > 0 else 26

def get_char_given_position(pos, is_lower):
  if is_lower:
    return chr(pos + 96)
  else:
    return chr(pos + 64)

if __name__ == "__main__":
  print(rot13("test"))
  print(rot13("test123"))
  print(rot13("ZANY_&^%@#$)%&)!^"))

#5Kyu; passed in 35 minutes
