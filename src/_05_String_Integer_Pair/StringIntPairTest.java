package _05_String_Integer_Pair;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringIntPairTest {

	@Test
	void testPutAndGet() {
		StringIntegerPair sip = new StringIntegerPair();
		sip.put("ONE", 1);
		sip.put("TWO", 2);
		sip.put("THREE", 3);
		sip.put("FOUR", 4);
		
		assertEquals(1, sip.get("ONE"));
		assertEquals(2, sip.get("TWO"));
		assertEquals(3, sip.get("THREE"));
		assertEquals(4, sip.get("FOUR"));
	}
	
	@Test
	void testContains() {
		StringIntegerPair sip = new StringIntegerPair();
		sip.put("ONE", 1);
		sip.put("TWO", 2);
		sip.put("THREE", 3);
		sip.put("FOUR", 4);
		
		assertTrue(sip.containsKey("ONE"));
		assertTrue(sip.containsKey("TWO"));
		assertTrue(sip.containsKey("THREE"));
		assertTrue(sip.containsKey("FOUR"));
		assertFalse(sip.containsKey("FIVE"));
		
		assertTrue(sip.containsValue(1));
		assertTrue(sip.containsValue(2));
		assertTrue(sip.containsValue(3));
		assertTrue(sip.containsValue(4));
		assertFalse(sip.containsValue(5));
	}
	
	@Test
	void testGetKeysAndValues() {
		StringIntegerPair sip = new StringIntegerPair();
		sip.put("ONE", 1);
		sip.put("TWO", 2);
		sip.put("THREE", 3);
		sip.put("FOUR", 4);
		
		int[] values = sip.getValues();
		String[] keys = sip.getKeys();
		
		assertEquals("ONE", keys[0]);
		assertEquals("TWO", keys[1]);
		assertEquals("THREE", keys[2]);
		assertEquals("FOUR", keys[3]);
		
		assertEquals(1, values[0]);
		assertEquals(2, values[1]);
		assertEquals(3, values[2]);
		assertEquals(4, values[3]);
	}

}
