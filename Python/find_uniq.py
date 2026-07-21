def find_uniq(arr):
  common_element = arr[0]
  if arr[0] == arr[1] or arr[0] == arr[2]:
    common_element = arr[0]
  else:
    common_element = arr[1]
  uniq = -1
  for n in arr:
    #print(f"n = {n}")
    #print(f"common_element = {common_element}")
    #print(f"Are they equal? {n == common_element}")
    if n != common_element:
      uniq = n
      break
  return uniq
    
if __name__ == "__main__":
  print(f"find_uniq returned {find_uniq([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1])}")

#6Kyu (more like 7 or 8Kyu) completed within 15 minutes
