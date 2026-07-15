#Param - stocklist = list of strings that begin with the category name ("AFHEUJF" refers to group 'A') followed by a space and the number of books in stock for that said category; categories = a list of characters that represent the groups categories by letter which are to be considered for the output. The goal of this function is to find out how many books exist in each category given categories to search for and the stocklist containing all the books
#Return - formatted string whose format is as follows:
  #Given that 10 books were identified from category A, 5 from B, and 0 from C, I would return the following string: "(A : 10) - (B : 5) - (C : 0)"
#Examples:
  #1 
    #b = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"]
    #c = ["A", "B", "C", "W"]
    #stock_list(b, c) should return: "(A : 20) - (B : 114) - (C : 50) - (W : 0)"
  #2
    #b = ['ROXANNE 102', 'RHODODE 123', 'BKWRKAA 125', 'BTSQZFG 239', 'DRTYMKH 060']
    #c = []
    #stock_list(b, c) should return: ""
  #3
    #b = ["ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"]
    #c = ["A", "B"]
    #stock_list(b, c) should return: "(A : 200) - (B : 1140)"
#Pseudocode:
#make empty string res = ""
#make a map called res_map
#loop through every string of the stocklist
#make int current_stock_count = res_map.getval(str.charat[0])
#if current_stock_count > 0, then res_map.add(str.charat[0], current_stock_count + str.get_second_word)
#else res_map.add(str.charat[0], str.get_second_word)
#after loop ends, loop again through each element of categories
#if res_map.get(ctg) != None then 
  #if res == "" then res += "(" + ctg + " : " + res_map.getval(ctg) + ")"
  #else res += " - (" + ctg + " : " + res_map.getval(ctg) + ")"
#return res
def stock_list(stocklist, categories):
  res = ""
  res_map = {}
  empty_input_exists = False
  for s in stocklist:
    if s == "":
      empty_input_exists = True
      break
    first_char = s[0]
    stock_count_to_add = int(s.split(" ")[1])
    print(f"current element in stocklist = {s}; current res_map = {res_map}; stock_count_to_add = {stock_count_to_add}")
    if first_char in categories:
      if first_char in res_map:
        current_stock_count = int(res_map[first_char])
        res_map[first_char] = current_stock_count + stock_count_to_add
      else:
        res_map[first_char] = stock_count_to_add
  print(f"final element in stocklist = {s}; current res_map = {res_map}")
  some_category_exists = False
  if not empty_input_exists:
    for c in categories:
      if c in res_map:
        val = str(res_map[c])
        some_category_exists = True
      else:
        val = "0"
      if res == "":
        res += "(" + c + " : " + val + ")"
      else:
        res += " - (" + c + " : " + val + ")"
      print(f"Res = {res}")
  return res if some_category_exists and not empty_input_exists else ""

if __name__ == "__main__":
  l1 = ["ABCD 15", "BED 4"]
  c1 = ["A", "B"]
  stock_list(l1, c1)
  l2 = ["ABCD 5", "BED 4", "AGD 1", "BAD 6", "CDG 7"]
  c2 = ["A", "B"]
  stock_list(l2, c2) #should return {'A': '6', 'B': '10'}

#6kyu, Solved in 54 minutes
