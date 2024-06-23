package Assignments.Assignment2;

import java.util.*;

import Assignments.Assignment2.Exceptions.*;

/**
 * @author Youssef Ali Ahmed Contains methods to convert infix to postfix, postfix to infix and evaluate postfix
 *         expressions
 */

public class Notation {
    private static Character[] op = { '+', '-', '*', '/' };
    private static ArrayList<Character> operators = new ArrayList<>(Arrays.asList(op));

    /**
     * converts infix expression to postfix expression
     * 
     * @param infix expression as a String
     * @return postfix expression as a String
     * @throws InvalidNotationFormatException if the infix expression is invalid
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

        String result = "";
        infix = infix.replaceAll("\\s", "");
        MyStack<Character> stack = new MyStack<>(infix.length());

        HashMap<Character, Integer> heiarchy = new HashMap<>();
        heiarchy.put('+', 1);
        heiarchy.put('-', 1);
        heiarchy.put('*', 2);
        heiarchy.put('/', 2);
        heiarchy.put('(', 0);
        heiarchy.put(')', 0);

        // Checks for invalid character
        for (char c : infix.toCharArray()) {
            if (!Character.isDigit(c) && !heiarchy.containsKey(c)) {
                throw new InvalidNotationFormatException();
            }
        }
        // Check for equal open and closed parenthesis
        int open = 0;
        int closed = 0;
        for (char c : infix.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                closed++;
            }
        }
        if (open != closed) {
            throw new InvalidNotationFormatException();
        }

        try {
            for (int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);

                if (Character.isDigit(c)) {
                    result += c;
                } else if (c == '(') {
                    stack.push(c);
                } else if (heiarchy.get(c) > heiarchy.get(stack.top())) {
                    stack.push(c);
                } else if (c == ')') {
                    while (stack.top() != '(') {
                        result += stack.pop();
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && heiarchy.get(c) <= heiarchy.get(stack.top())) {
                        result += stack.pop();
                    }
                    stack.push(c);
                }
            }
        } catch (StackOverflowException e) {
            e.printStackTrace();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * converts postfix expression to infix expression
     * 
     * @param postfix expression as a String
     * @return infix expression as a String
     * @throws InvalidNotationFormatException if the postfix expression is invalid
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

        String result = "";
        postfix = postfix.replaceAll("\\s", "");
        MyStack<String> stack = new MyStack<>(postfix.length());

        try {
            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);
                if (Character.isDigit(c)) {
                    stack.push(Character.toString(c));
                } else if (operators.contains(c)) {
                    if (stack.size() < 2) {
                        throw new InvalidNotationFormatException();
                    } else {
                        String num2 = stack.pop();
                        String str = "(" + stack.pop() + c + num2 + ")";
                        stack.push(str);
                    }
                }
            }
            result = stack.pop();
        } catch (StackOverflowException e) {
            e.printStackTrace();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * evaluates a postfix expression
     * 
     * @param postfixExpr as a String
     * @return the result of the expression as a double
     * @throws InvalidNotationFormatException
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        postfixExpr = postfixExpr.replaceAll("\\s", "");
        MyStack<Double> stack = new MyStack<>(postfixExpr.length());
        double result = 0;
        try {
            for (int i = 0; i < postfixExpr.length(); i++) {
                char c = postfixExpr.charAt(i);
                String s = String.valueOf(c);

                if (Character.isDigit(c)) {
                    stack.push(Double.parseDouble(s));
                } else if (operators.contains(c)) {
                    if (stack.size() < 2) {
                        throw new InvalidNotationFormatException();
                    }
                    Double num2 = stack.pop();
                    Double num1 = stack.pop();
                    switch (c) {
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    }
                } else {
                    throw new InvalidNotationFormatException();
                }
            }
            if (stack.size() > 1) {
                throw new InvalidNotationFormatException();
            }
            result = stack.pop();
        } catch (StackOverflowException e) {
            e.printStackTrace();
        } catch (StackUnderflowException e) {
            e.printStackTrace();
        }
        return result;
    }
}