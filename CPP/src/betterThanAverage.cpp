#include <vector>

bool betterThanAverage(std::vector<int> classPoints, int yourPoints) {
  double total_points = 0;
  for(int point : classPoints) {
    total_points += point;
  }
  double average_points = total_points / classPoints.size();
  return yourPoints > average_points;
}
//solved in 8 minutes, 8kyu
