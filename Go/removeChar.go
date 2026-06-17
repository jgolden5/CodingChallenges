package main

func RemoveChar(word string) string {
  wordLength := len(word)
  choppedWord := word[1:wordLength - 1]
  return choppedWord
}
