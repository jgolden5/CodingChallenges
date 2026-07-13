#6KYU - https://www.codewars.com/kata/56a5d994ac971f1ac500003e/train/python
#Parameters: strarr = array of strings; k = number of strings to bunch together at each array index
#Return: the longest concatenated substringss created from consecutive concatenations of elements in the array; if length of resulting string array <= 0 OR if k > number of strings in strarr, return ""
#Examples:
#Example 1:
  #longest_consec(["zone", "abigail", "theta", "form", "libe", "zas"], 2)
    #[
    #"zoneabigail", [length = 11]
    #"abigailtheta" [12] <- return this one
    #"thetaform" [9]
    #"formlibe" [8]
    #"libezas" [7]
    #]
    #expected result = "abigailtheta"
#Example 2:
  #longest_consec(["a", "bc", "def", "ghijklm"], 3)
  #"abcdef" [6]
  #"bcdefghijklmn" [13] <- return this one
  #expected result = "bcdefghijklmn"
#Pseudocode:
#res = ""
#concatenated_strings = []
#if k > len(strarr) then return ""
#while i <= len(strarr) - k
#on each pass through the array, concatenate elements at strarr[i] - strarr[i + k - 1] and add each concatenated string as a separate entry to concatenated_strings array
#if len(concatenated_strings) == 0 then return ""
  #else loop through array again to identify the longest string in the array
  #set res = longest_string (identified in previous step)
  #return res
def longest_consec(strarr, k):
  longest = ""
  concatenated_strings = []
  print(f"Given {strarr}, {k}...")
  if k < len(strarr):
    i = 0
    while i <= len(strarr) - k:
      j = i
      string_to_concat = ""
      while j < i + k:
        string_to_concat += strarr[j]
        j += 1
      concatenated_strings.append(string_to_concat)
      i += 1
  for s in concatenated_strings:
    if longest == "" or len(longest) < len(s):
      longest = s
  return longest

if __name__ == "__main__":
  a1 = ["a", "bc", "def", "ghij"]
  print(f"Answer was: {longest_consec(a1, 2)}")
  print(f"Answer was: {longest_consec(a1, 3)}")

#solved in 44 minutes ✅
