#include <iostream>
#include <vector>
#include <string>
#include <array>

//parameters: read-only reference to vector of strings named words. words - vector of words to be smashed into a sentence
std::string sentence_smash(const std::vector<std::string>& words) {
  std::string res = "";
  for(int i = 0; i < words.size(); ++i) {
    std::string word = words[i];
    res += word;
    if(i < words.size() - 1) {
      res += " ";
    }
  }
  return res;
}

//Solved in under 26 minutes (8 KYU [first c++ kata])
