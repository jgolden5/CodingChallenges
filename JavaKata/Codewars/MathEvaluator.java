package Codewars;

import java.util.ArrayList;
import java.util.Stack;

public class MathEvaluator {

  public double calculate(String infix) {
    ArrayList<String> infixArrayList = infixStringToArrayList(infix);
    ArrayList<String> cleanInfixArrayList = fixInfixArrayListMinuses(infixArrayList);
    ArrayList<String> postfixArrayList = infixToPostfixArrayList(cleanInfixArrayList);
    ArrayList<String> cleanPostfixArrayList = realignPostfixOps(postfixArrayList);
    return rpnCalculator(cleanPostfixArrayList);
  }

  double rpnCalculator(ArrayList<String> postfixArrayList) {
    Stack<Double> operandStack = new Stack<>();
    for(String token : postfixArrayList) {
      if("*/+-".contains(token)) {
        double x, y;
        switch(token) {
          case "*":
            y = operandStack.pop();
            x = operandStack.pop();
            operandStack.push(x * y);
            break;
          case "/":
            y = operandStack.pop();
            x = operandStack.pop();
            operandStack.push(x / y);
            break;
          case "+":
            y = operandStack.pop();
            x = operandStack.isEmpty() ? 0 : operandStack.pop();
            operandStack.push(x + y);
            break;
          case "-":
            y = operandStack.pop();
            x = operandStack.isEmpty() ? 0 : operandStack.pop();
            operandStack.push(x - y);
            break;
        }
      } else {
        operandStack.push(Double.parseDouble(token));
      }
    }
    return operandStack.pop();
  }

  ArrayList<String> realignPostfixOps(ArrayList<String> postfixOps) {
    ArrayList<String> cleanResult;
    int numCount = 0;
    int opCount = 0;
    int indexOfLastNumber = 0;
    cleanResult = new ArrayList<>();
    boolean mustSwapAfterNextToken = false;
    for(int i = 0; i < postfixOps.size(); i++) {
      String token = postfixOps.get(i);
      cleanResult.add(token);
      if(mustSwapAfterNextToken) {
        cleanResult = swapLastTwo(cleanResult);
      }
      if ("*/+-".contains(token)) {
          opCount++;
          if(opCount == numCount) {
            if(token.equals("-") && !nextOpIsMinus(i, postfixOps)) {
              cleanResult = negateNumberAtIndex(indexOfLastNumber, cleanResult);
              opCount--;
            } else {
              mustSwapAfterNextToken = true;
            }
          }
        } else {
          numCount++;
          indexOfLastNumber = mustSwapAfterNextToken ? i - 1 : i;
          mustSwapAfterNextToken = false;
        }
    }
    return cleanResult;
  }

  private boolean nextOpIsMinus(int startingIndex, ArrayList<String> postfixOps) {
    String nextOp = "";
    for(int i = startingIndex + 1; i < postfixOps.size(); i++) {
      String token = postfixOps.get(i);
      if("*/+-".contains(token)) {
        nextOp = token;
        break;
      }
    }
    return nextOp.equals("-");
  }

  ArrayList<String> swapLastTwo(ArrayList<String> brokenPostfix) {
    ArrayList<String> cleanPostfix = brokenPostfix;
    String operator = brokenPostfix.get(brokenPostfix.size() - 2);
    String operand = brokenPostfix.get(brokenPostfix.size() - 1);
    cleanPostfix.remove(cleanPostfix.size() - 1);
    cleanPostfix.remove(cleanPostfix.size() - 1);
    cleanPostfix.add(cleanPostfix.size(), operand);
    cleanPostfix.add(cleanPostfix.size(), operator);
    return cleanPostfix;
  }

  ArrayList<String> negateNumberAtIndex(int indexOfNumToNegate, ArrayList<String> postfixOps) {
    ArrayList<String> result = new ArrayList<>();
    boolean ignoreNextMinus = false;
    for(int i = 0; i < postfixOps.size(); i++) {
      String token = postfixOps.get(i);
      if(ignoreNextMinus && token.equals("-")) {
        ignoreNextMinus = false;
      } else if(i != indexOfNumToNegate || token.equals("0")) {
          result.add(token);
      } else {
        result.add("-" + token);
        ignoreNextMinus = true;
      }
    }
    return result;
  }

  public boolean postfixOpsAreValid(ArrayList<String> postfixOps) {
    int numCount = 0;
    int opCount = 0;
    for(String token : postfixOps) {
      if("*/+-".contains(token)) {
        opCount++;
      } else {
        numCount++;
      }
    }
    return numCount == opCount + 1;
  }

  /**
   * loop through every element of infixArrayList
     * if !"()*\/+-".contains(currentInfix)
       * add token to postfixResult
     * else
       * while shouldPopFromOpStackToPostfixResult
         * postfixResult.add(opStack.pop())
       * opStack.push(token)
   * add any remaining elements from opStack to postfixArrayList
   * @param infixArrayList
   * @return
   */
  ArrayList<String> infixToPostfixArrayList(ArrayList<String> infixArrayList) {
    ArrayList<String> postfixResult = new ArrayList<>();
    Stack<String> opStack = new Stack<>();
    boolean shouldNegateNextNumber = false;
    for (int i = 0; i < infixArrayList.size(); i++) {
      String token = infixArrayList.get(i);
      if(!"()*/+-".contains(token)) {
        if(shouldNegateNextNumber) {
          postfixResult.add("-" + token);
          opStack.pop();
          shouldNegateNextNumber = false;
        } else {
          postfixResult.add(token);
        }
      } else if(token.equals(")")) {
        while(!opStack.peek().equals("(")) {
          postfixResult.add(opStack.pop());
        }
        opStack.pop();
      } else {
        shouldNegateNextNumber = i > 0 && infixArrayList.get(i).equals("-") && infixArrayList.get(i - 1).equals("(");
        while(!opStack.isEmpty() && !opStack.peek().equals("(") &&
          ("*/".contains(token) && "*/".contains(opStack.peek()) || "+-".contains(token))) {
            postfixResult.add(opStack.pop());
        }
        opStack.push(token);
      }
    }
    while(!opStack.isEmpty()) {
      postfixResult.add(opStack.pop());
    }
    return postfixResult;
  }

  /**
   * for each token in infixArrayList
     * if token equals "-", increment minusCount
     * else if minusCount == 0, add token to cleanInfixArrayList
     * else if minusCount == 1 and token is a number, add "-" + token to cleanInfixArrayList, then reset minusCount to 0
     * else if minusCount % 2 == 0, add "+" to cleanInfixArrayList, and reset minusCount to 0
     * else add "+" to cleanInfixArrayList, add "-" + token to cleanInfixArrayList, then reset minusCount to 0
   * @param infixArrayList
   * @return
   */
  ArrayList<String> fixInfixArrayListMinuses(ArrayList<String> infixArrayList) {
    ArrayList<String> cleanInfixArrayList = new ArrayList<>();
    boolean shouldNegate = false;
    int unresolvedParenthesesNeedingNegation = 0;
    for (int i = 0; i < infixArrayList.size(); i++) {
      String token = infixArrayList.get(i);
      String prevToken = i > 0 ? infixArrayList.get(i - 1) : " ";
      String nextToken = i < infixArrayList.size() - 1 ? infixArrayList.get(i + 1) : " ";
      if (token.equals("-") && (!isNumber(prevToken) || !isNumber(nextToken))) {
        shouldNegate = !shouldNegate || unresolvedParenthesesNeedingNegation > 0;
        if(i > 0 && nextToken.equals("(")) {
          if(unresolvedParenthesesNeedingNegation % 2 == 0) {
            cleanInfixArrayList.add("+");
          } else {
            cleanInfixArrayList.add("-");
          }
        }
      } else {
        if (shouldNegate && isNumber(token)) {
          token = negateToken(token);
          shouldNegate = unresolvedParenthesesNeedingNegation > 0;
        }
        if (token.equals("(")) {
          unresolvedParenthesesNeedingNegation++;
        } else if (token.equals(")")) {
          unresolvedParenthesesNeedingNegation--;
        }
        String prevClean = cleanInfixArrayList.size() > 0 ? cleanInfixArrayList.get(cleanInfixArrayList.size() - 1) : "";
        if (isNumber(token) && cleanInfixArrayList.size() > 0 && isNumber(prevClean)) {
          cleanInfixArrayList.add("+");
        }
        cleanInfixArrayList.add(token);
      }
    }
    return cleanInfixArrayList;
  }

  private boolean isNumber(String token) {
    char lastChar = token.charAt(token.length() - 1); //last so that minus sign is ignored
    return "0123456789".contains(String.valueOf(lastChar));
  }

  private String negateToken(String token) {
    if(token.charAt(0) == '-') {
      return token.substring(1);
    } else {
      return "-" + token;
    }
  }

  /**
   * Declare all necessary variables for the following operations
   * Loop through every char in infix String
     * a) if nextChar is number (0-9 or .), then
       * if previous char was number, append nextChar to last char in stack (eg. prevChar = "12", nextChar = "3", push("123"))
       * else push nextChar to infixStack like normal
     * b) else if nextChar does not equal " ", push nextChar to infixStack
   * return resulting infixStack
   * @param infixString
   * @return infixStack
   */
  ArrayList<String> infixStringToArrayList(String infixString) {
    ArrayList<String> infixArrayList = new ArrayList<>();
    final String validNumbers = "0123456789.";
    for(int i = 0; i < infixString.length(); i++) {
      int infixArrayListLast = infixArrayList.size() - 1;
      String nextChar = String.valueOf(infixString.charAt(i));
      String prevChar = infixArrayList.size() > 0 ? String.valueOf(infixArrayList.get(infixArrayListLast).charAt(0)) : " ";
      if(validNumbers.contains(nextChar)) {
        if(validNumbers.contains(prevChar)) {
          prevChar = infixArrayList.remove(infixArrayListLast);
          nextChar = prevChar + nextChar;
        }
        infixArrayList.add(nextChar);
      } else if(!nextChar.equals(" ")) {
        infixArrayList.add(nextChar);
      }
    }
    return infixArrayList;
  }

}