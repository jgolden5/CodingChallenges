#include <string>
#include <map>

enum Side {
  LEFT,
  RIGHT
};

struct TeamData {
  const Side side;
  std::map<char, int> fightData;
  int score;
};

std::string alphabetWar(std::string fight);
