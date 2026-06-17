package main

import (
  //"fmt"
)

func EachCons(sliceSource []int, n int) [][]int {
	var subsets [][]int
	if len(sliceSource) == 0 {
		return subsets
	} else {
    for i := 0; i <= len(sliceSource) - n; i++ {
      sliceToAppend := sliceSource[i:(i + n)]
      subsets = append(subsets, sliceToAppend)
    }
    return subsets
	}
}
