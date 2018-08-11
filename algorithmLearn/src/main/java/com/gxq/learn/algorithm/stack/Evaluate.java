/**
 * 
 */
package com.gxq.learn.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Administrator
 *
 */
public class Evaluate {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String s = scan.nextLine();
			if (s.equals("(")) {
				;
			} else if (s.equals("+")) {
				ops.push(s);
			} else if (s.equals("-")) {
				ops.push(s);
			} else if (s.equals("*")) {
				ops.push(s);
			} else if (s.equals("/")) {
				ops.push(s);
			} else if (s.equals("sqrt")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) {
					v = vals.pop() + v;
				}
				if (op.equals("-")) {
					v = vals.pop() - v;
				}
				if (op.equals("*")) {
					v = vals.pop() * v;
				}
				if (op.equals("/")) {
					v = vals.pop() / v;
				}
				if (op.equals("sqrt")) {
					v = Math.sqrt(v);
				}
				vals.push(v);
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		System.out.println(vals.pop());
	}

}
