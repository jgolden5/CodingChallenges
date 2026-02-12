#!/bin/bash

sqInRect() {
  squares=" "
  rSqInRect $1 $2 "$squares"
}

rSqInRect() {
  squares="$3"
  if [[ $1 -lt $2 ]]; then 
    min=$1
    max=$2
  elif [[ $1 -gt $2 ]]; then
    min=$2
    max=$1
  else
    echo "nil"
    return
  fi
  squares+="$min "
  newDimension1=$(( max - min ))
  newDimension2=$(( (max * min - min * min) / newDimension1 ))
  if [[ $newDimension1 -ne $newDimension2 ]]; then
    rSqInRect $newDimension1 $newDimension2 "$squares"
  else
    squares+=$min
    echo $squares
  fi
}
sqInRect $1 $2
