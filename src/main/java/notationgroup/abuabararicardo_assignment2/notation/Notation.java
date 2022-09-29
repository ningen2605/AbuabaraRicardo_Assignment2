package notationgroup.abuabararicardo_assignment2.notation;

import java.util.ArrayList;
/**
 * This utility class converts infix to postfix notation strings and viceversa, and also evaluates
 * those strings.
 *
 * @author Ricardo Abuabara
 *
 */
public class Notation {
	private static MyQueue<String> nQueue;
	private static MyStack<String> nStack;
	/**
	 * Evaluates a postfix expression from a string to a double
	 *
	 * @param postfixExpr
	 * @return postfix expression evaluated as double
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		nQueue = new MyQueue<String>(postfixExpr.length());
		nStack = new MyStack<String>(postfixExpr.length());

		int r = 0;

		MyStack<String> s_t = new MyStack<String>(2);

		String[] i = postfixExpr.split("");

		try {
			for (String c : i) {

				// if space
				if (c.equals(" ")) {
					continue;
				}

				// if integer
				if (isInteger(c)) {
					nStack.push(c);
				}

				// if operator
				if (isOperator(c)) {
					s_t.push(nStack.pop());
					s_t.push(nStack.pop());
					nStack.push(String.valueOf(evaluation(c,s_t.pop(),s_t.pop())));
				}
			}
			// check if one or more values
			if(nStack.size()>1) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		return Integer.parseInt(nStack.toString());
	}

	/**
	 * Convert the Postfix expression to the Infix expression
	 *
	 * @param postfix expression
	 * @return infix expression
	 * @throws InvalidNotationFormatException
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix)
			throws InvalidNotationFormatException {
		nQueue = new MyQueue<String>(postfix.length());
		nStack = new MyStack<String>(postfix.length());

		MyStack<String> s_t = new MyStack<String>(2);

		String[] i = postfix.split("");

		try {
			for (String c : i) {

				// if space
				if (c.equals(" ")) {
					continue;
				}

				// if integer
				if (isInteger(c)) {
					nStack.push(c);
				}

				// if operator
				if (isOperator(c)) {
					s_t.push(nStack.pop());
					s_t.push(nStack.pop());
					nStack.push("("+s_t.pop()+c+s_t.pop()+")");
				}
			}

			// check if one or more values
			if(nStack.size()>1) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		return nStack.toString();
	}

	/**
	 * Convert an infix expression into a postfix expression
	 *
	 * @param infix expression
	 * @return postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {
		nQueue = new MyQueue<String>(infix.length());
		nStack = new MyStack<String>(infix.length());

		String[] i = infix.split("");

		try {
			for (String c : i) {

				// if space
				if (c.equals(" ")) {
					continue;
				}

				// if integer
				if (isInteger(c)) {
					nQueue.enqueue(c);
				}

				// if left parenthesis
				if (c.equals("(")) {
					nStack.push(c);
				}

				// if operator
				if (isOperator(c)) {
					if (!nStack.isEmpty() && isOperator(nStack.top()) && isHigherEqualPrecedence(nStack.top(),c)) {
						nQueue.enqueue(nStack.pop());
					}
					nStack.push(c);
				}

				// if right parenthesis
				if (c.equals(")")) {
					while (!nStack.isEmpty() && isOperator(nStack.top())) {
						nQueue.enqueue(nStack.pop());
					}
					if(!nStack.isEmpty() && nStack.top().equals("(")) {
						nStack.pop();
					} else {
						throw new Exception();
					}
				}
			}

			while (!nStack.isEmpty() && isOperator(nStack.top())) {
				nQueue.enqueue(nStack.pop());
			}
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		return nQueue.toString();
	}

	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
	}


	/**
	 * Checks for the string to have integers
	 * @param s String given
	 * @return boolean expression true if it has all integers and throws and exception if it has no integers
	 */
	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * determines the operators in the string
	 * @param s string given with parameters
	 * @return boolean expression true if it finds any operators, returns false if there are none
	 */
	private static boolean isOperator(String s) {
		switch (s) {
			case "+":
			case "-":
			case "*":
			case "/":
				return true;
			default:
				return false;
		}
	}

	/**
	 * checks precedence in operators
	 *
	 * @param a
	 * @param b
	 * @return if operator a >= b in precedence
	 */
	private static boolean isHigherEqualPrecedence(String a, String b) {
		int a_1;
		int b_1;

		a_1 = a=="*" || a=="/" ? 1 : 0;
		b_1 = b=="*" || b=="/" ? 1 : 0;

		return a_1>=b_1;
	}

	/**
	 * Evalutates the String of the full operation and determines which operations go first on a String
	 * @param op the full String of arguments
	 * @param strA String that finds the integers and their operation
	 * @param strB String that finds the integers and their operations
	 * @return
	 */
	private static int evaluation(String op, String strA, String strB) {
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);
		switch(op) {
			case "+":
				return a+b;
			case "-":
				return a-b;
			case "*":
				return a*b;
			case "/":
				return a/b;
			default:
		}
		return 0;
	}

}
