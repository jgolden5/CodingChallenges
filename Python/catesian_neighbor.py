def cartesian_neighbor(x, y):
  neighbors = []
  neighbors.append((x - 1, y - 1))
  neighbors.append((x - 1, y))
  neighbors.append((x - 1, y + 1))
  neighbors.append((x, y - 1))
  neighbors.append((x, y + 1))
  neighbors.append((x + 1, y - 1))
  neighbors.append((x + 1, y))
  neighbors.append((x + 1, y + 1))
  return neighbors

if __name__ == "__main__":
  print(cartesian_neighbor(2, 2))

#Passed after 57 minutes
