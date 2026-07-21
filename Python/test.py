import sys

def f():
  file_name = sys.argv[0]
  test_args = sys.argv[1:]
  print(f"file name = {file_name}")
  pos = 1
  for arg in test_args:
    print(f"{pos} - {arg}")
    pos += 1

if __name__ == "__main__":
  f()
