#include <iostream>
#include "../include/alphabetWar.h"

int main() {
  const std::string w1 = alphabetWar("wmpqdbsz");
  std::cout << w1 << std::endl;
  const std::string w2 = alphabetWar("wmpqdbbz");
  std::cout << w2 << std::endl;
  const std::string w3 = alphabetWar("zwmpqdbsz");
  std::cout << w3 << std::endl;
  return 0;
}
