package Codewars;

import java.util.Stack;

public class ReversePolish {
  public double evaluate(String expr) {
    String[] expressionAsStringArray = expr.split(" ");
    Stack<String> stack = new Stack<>();
    String operators = "+-*/";
    if(expr.length() == 0) {
      return 0;
    } else {
      for(int i = 0; i < expressionAsStringArray.length; i++) {
        String currentElement = expressionAsStringArray[i];
        if(operators.contains(currentElement)) {
          double op1 = Double.parseDouble(stack.pop());
          double op2 = Double.parseDouble(stack.pop());
          switch(currentElement) {
            case "+" -> stack.push(Double.toString(op2 + op1));
            case "-" -> stack.push(Double.toString(op2 - op1));
            case "*" -> stack.push(Double.toString(op2 * op1));
            case "/" -> stack.push(Double.toString(op2 / op1));
            default -> System.out.println("current element \"" + currentElement + "\" not recognized");
          }
        } else {
          stack.push(currentElement);
        }
      }
    }
    return Double.parseDouble(stack.pop());
  }
}
