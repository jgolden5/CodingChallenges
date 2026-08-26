#include <string>
#include <vector>
#include <iostream>

void printArrayContents(const std::vector<std::string>& arr) {
  for(std::string s: arr) {
    std::cout << s << std::endl;
  }
}

std::vector<std::string> friendOrFoe(const std::vector<std::string>& input) {
  std::vector<std::string> friends;
  for(std::string s: input) {
    if(s.length() == 4) {
      friends.push_back(s);
    }
  }
  printArrayContents(friends);
  return friends;
}

//solved in 45 minutes, 7kyu, 8-26-26
