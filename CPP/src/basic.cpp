#include <iostream>

void understanding_pointers() {
  int* pointer = new int(12);
  std::cout << "pointer = " << pointer << '\n';

  int** pointer_address = &pointer;
  std::cout << "pointer_address = " << pointer_address << '\n';

  int value_pointer_is_pointing_to = *pointer;
  std::cout << "value_pointer_is_pointing_to " << value_pointer_is_pointing_to << '\n';

  int* pointer_copy = pointer;
  std::cout << "pointer_copy " << pointer_copy << '\n';

  std::string value = "some string";
  std::string* pointer_given_value = &value; //get address of value variable and store it in pointer

  delete pointer; //deallocates memory from pointer
  pointer = nullptr;
}
