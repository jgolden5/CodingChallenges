import sys

def add(x, y):
  print(f"x = {x}; y = {y}")
  return x + y

def subtract(x, y):
  print(f"x = {x}; y = {y}")
  return x - y

def multiply(x, y):
  print(f"x = {x}; y = {y}")
  return x * y

def add_then_subtract_then_multiply(x, y):
  sum_res = add(x, y)
  diff_res = subtract(sum_res, y)
  prod_res = multiply(sum_res, diff_res)
  return prod_res

def f():
  file_name = sys.argv[0]
  test_args = sys.argv[1:]
  print(f"file name = {file_name}")
  pos = 1
  for arg in test_args:
    print(f"{pos} - {arg}")
    pos += 1

if __name__ == "__main__":
  add_then_subtract_then_multiply(1, 2) #should return 3
  add_then_subtract_then_multiply(0, 2)
