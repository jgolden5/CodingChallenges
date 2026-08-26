#include <algorithm>
#include <iostream>
#include "../include/findDeletedNumber.h"

using namespace std;

int findDeletedNumber(list<int> startingList, list<int> mixedList) {
  int result = 0;
  for(int se: startingList) {
    bool someElementWasEqual = false;
    for(int me: mixedList) {
      cout << "Starting element: " << se << endl;
      cout << "Mixed element: " << me << endl;
      if(se == me) {
        someElementWasEqual = true;
        break;
      }
    }
    if(!someElementWasEqual) {
      result = se;
      goto finish;
    }
  }
  finish:
  return result;
}

//solved in 36 minutes, 7Kyu
