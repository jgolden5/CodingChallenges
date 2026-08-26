#include <iostream>
#include <list>
#include "../include/findDeletedNumber.h"

int main() {
  const std::list<int> starting = {1, 2, 3, 4, 5, 6};
  const std::list<int> mixed = {2, 4, 6, 3, 1};
  std::cout << findDeletedNumber(starting, mixed) << std::endl;
  return 0;
}
