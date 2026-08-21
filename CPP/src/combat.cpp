#include <iostream>
#include "../include/combat.h"

int combat(int health, int damage) {
  int health_remaining = health - damage;
  if(health_remaining < 0) {
    health_remaining = 0;
  }
  return health_remaining;
}

//8kyu, solved within 31 minutes
