#include <iostream>
#include <string>
#include <vector>
#include "sentence_smash.h"

int main() {
  std::vector<std::string> words {
    "hello",
    "world"
  };
  std::string sentence = sentence_smash(words);
  std::cout << sentence << std::endl;
  return 0;
}
