package _02_Integer_Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntegerStackTest {

	@Test
	void testPushAndPop() {
		IntegerStack is = new IntegerStack();
		is.push(0);
		is.push(1);
		is.push(2);
		is.push(3);
		is.push(4);
		
		assertEquals(4, is.pop());
		assertEquals(3, is.pop());
		assertEquals(2, is.pop());
		assertEquals(1, is.pop());
		assertEquals(0, is.pop());
	}
	
	@Test
	void testClear() {
		IntegerStack is = new IntegerStack();
		is.push(0);
		is.push(1);
		is.push(2);
		is.push(3);
		is.push(4);
		is.clear();
		assertEquals(0, is.size());
	}

}
