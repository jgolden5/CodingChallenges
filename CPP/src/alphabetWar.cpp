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
  public:
    TeamData(const Side m_side, std::map<char, int> m_fightData, int m_score):
      side(m_side), fightData(m_fightData), score(m_score) {}
};

std::string alphabetWar(std::string fight) {
  std::map<char, int> leftSideFightData = { {'w', 4}, {'p', 3}, {'b', 2}, {'s', 1} };
  std::map<char, int> rightSideFightData = { {'m', 4}, {'q', 3}, {'d', 2}, {'z', 1} };
  enum Side leftSide = LEFT;
  enum Side rightSide = RIGHT;
  TeamData leftTeam = TeamData(leftSide, leftSideFightData, 0);
  TeamData rightTeam = TeamData(rightSide, rightSideFightData, 0);

  for(char& c : fight) {
    if(leftTeam.fightData.count(c)) {
      leftTeam.score += leftTeam.fightData[c];
    } else if(rightTeam.fightData.count(c)) {
      rightTeam.score += rightTeam.fightData[c];
    }
  }

  std::string returnMessage;
  if(leftTeam.score > rightTeam.score) {
    returnMessage = "Left side wins!";
  } else if (rightTeam.score > leftTeam.score) {
    returnMessage = "Right side wins!";
  } else {
    returnMessage = "Let's fight again!";
  }

  return returnMessage;

}

//completed in 49 minutes, 7kyu
