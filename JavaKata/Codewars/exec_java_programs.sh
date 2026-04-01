#!/bin/bash
#Just to make my life easier without Maven availability on work laptop

relevant_files=(Main.java CamelCase.java)
complete_filepaths=()

cd ../

for file in "${relevant_files[@]}"; do
  complete_filepaths+=("Codewars/$file")
done

javac "${complete_filepaths[@]}"
java "Codewars/Main"

cd Codewars/
rm *.class
