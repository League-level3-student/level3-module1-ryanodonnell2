package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random r = new Random();
		for (int i = 0; i < 101; i++) {
			doubles.push(r.nextDouble()*100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		int minVal = Integer.parseInt(JOptionPane.showInputDialog("Enter in one number between 0 and 100, inclusive."));
		int maxVal = Integer.parseInt(JOptionPane.showInputDialog("Enter in one number between 0 and 100, inclusive."));
		if(minVal>maxVal) {
			int temp = minVal;
			maxVal = minVal;
			minVal = temp;
		}
		else if(minVal == maxVal) {
			minVal = 0;
			maxVal = 100;
		}
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " +minVal+ " and " +maxVal+":");
		for (int i = 0; i < 101; i++) {
			if(i>minVal&&i<maxVal) {
				System.out.println(doubles.pop());
			}
		}
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
