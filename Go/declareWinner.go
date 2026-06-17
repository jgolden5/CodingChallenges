package main

import (
  //"fmt"
)

type Fighter struct {
  Name string
  Health int
  DamagePerAttack int
}

//note, the comments below are helpful to view fight progress in real time
func DeclareWinner(fighter1 Fighter, fighter2 Fighter, firstAttacker string) string {
  var defender Fighter
  var attacker Fighter
  if fighter1.Name == firstAttacker {
    attacker = fighter1
    defender = fighter2
  } else {
    attacker = fighter2
    defender = fighter1
  }
  for {
    //fmt.Println(defender.Name,"has",defender.Health,"health points")
    defender.Health -= attacker.DamagePerAttack
    //fmt.Println(attacker.Name,"does",attacker.DamagePerAttack,"damage to",defender.Name)
    //fmt.Println(defender.Name,"has",defender.Health,"health remaining")
    if defender.Health <= 0 {
      break
    } else {
      swapRoles(&defender, &attacker)
    }
  }
  return attacker.Name //this is the last one who attacked when the defender lost, hence, the winner
}

func swapRoles(defender *Fighter, attacker *Fighter) {
  temp := *defender
  *defender = *attacker
  *attacker = temp
}
