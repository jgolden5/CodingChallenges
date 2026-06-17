package main

import (
  "strings"
  "fmt"
)

func bandNameGenerator(word string) string {
  var bandName string
  firstChar := word[0:1]
  fmt.Println("firstChar:", firstChar) //
  lastCharIndex := len(word) - 1
  fmt.Println("lastCharIndex:", lastCharIndex) //
  lastChar := word[lastCharIndex:len(word)]
  fmt.Println("lastChar:", lastChar) //
  firstCharCapitalized := strings.ToUpper(firstChar)
  fmt.Println("firstCharCapitalized:", firstCharCapitalized) //
  remainingPortionOfWord := word[1:]
  fmt.Println("remainingPortionOfWord:", remainingPortionOfWord) //
  if firstChar == lastChar {
    bandName = firstCharCapitalized + remainingPortionOfWord + remainingPortionOfWord
  } else if strings.Contains(word, "-") {
    dashIndex := strings.Index(word, "-")
    fmt.Println("dashIndex:", dashIndex) //
    remainingPreDash := word[1:dashIndex]
    fmt.Println("remainingPreDash:", remainingPreDash) //
    secondCharCapitalized := strings.ToUpper(word[dashIndex+1:dashIndex+2])
    fmt.Println("secondCharCapitalized:", secondCharCapitalized) //
    remainingPostDash := word[dashIndex+2:]
    fmt.Println("remainingPostDash:", remainingPostDash) //
    bandName = "The " + firstCharCapitalized + remainingPreDash + "-" + secondCharCapitalized + remainingPostDash
  } else {
    bandName = "The " + firstCharCapitalized + remainingPortionOfWord
  }
  return bandName
}
