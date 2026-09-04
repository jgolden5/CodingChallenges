#include <iostream>
#include <vector>
#include "../include/betterThanAverage.h"

int main() {
  const std::vector<int> classPoints = { 90, 91, 92 };
  const int myPoints = 91;
  const bool iAmBetterThanAverage = betterThanAverage(classPoints, myPoints);
  std::cout << iAmBetterThanAverage << std::endl;
  return 0;
}
