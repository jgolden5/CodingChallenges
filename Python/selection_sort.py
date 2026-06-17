def selection_sort(a):
  sorted_array = a
  for i in range(len(a)):
    print(a)
    min_selection = a[i]
    for j in range(i, len(a)):
      if a[j] < min_selection:
        print(a)
        min_selection = a[j]
        continue
    a[i] = min_selection
    a[j] = a[i]
    continue
  return a

a1 = [3, 2, 1, 5, 3]
selection_sort(a1)
