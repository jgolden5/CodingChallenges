def find_a_b(numbers, c): #[1, 3, 5, 6, 10], 30
    res = None
    for i in range(len(numbers) - 1):
        if res != None:
            break
        x = numbers[i]
        for j in range(i + 1, len(numbers)):
            y = numbers[j]
            if x * y == c:
                res = [x, y]
                break
    return res

if __name__ == "__main__":
    print(find_a_b([1, 3, 5], 3))
    print(find_a_b([1, 3, 5, 6, 10], 30))

#Solved in 24 minutes; 6-25-26