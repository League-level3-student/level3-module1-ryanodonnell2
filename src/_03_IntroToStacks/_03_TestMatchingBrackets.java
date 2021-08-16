package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> brackets = new Stack<String>();
		for (int i = 0; i < b.length(); i++) {
			brackets.add(Character.toString(b.charAt(i)));
		}
		boolean onClosed = false;
		boolean allCompleted = false;
		for (int i = 0; i < brackets.size(); i++) {
			for (int j = brackets.size()-1; j < brackets.size()-i; j--) {
				if(brackets.get(i).equals("}")&&!onClosed) {
					onClosed = true;
					allCompleted = false;
					brackets.pop();
				}
				else if(brackets.get(i).equals("{")&&onClosed) {
						onClosed = false;
						allCompleted = true;
						break;
				}
			}
		}
		if (allCompleted) {
			return true;
		} else {
			return false;
		}
	}

}