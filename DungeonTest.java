

import static org.junit.Assert.*;

import org.junit.Test;

public class DungeonTest {
	@Test
	public void test() {
		CountWords words = new CountWords();
		String input = "Hello World Hello US for the"; 
		words.getWordFrequency(input);
		BinarySearchTree bst = words.getbst();
		assertEquals((bst.getFrequency("hellod")), 0);
		assertEquals((bst.getFrequency("us")), 1);
		
		assertTrue(bst.contains("HEllo"));
		assertFalse(bst.contains("an"));
		
		assertEquals(bst.size(),5);
		
		assertEquals(bst.getNodesList().size(),5);
		
		assertEquals(words.getAverage(),1.2,0.0);
		
		assertEquals(bst.getFrequencyList().size(),5);
		
		assertEquals(words.getStandardDeviation(),0.4,0.001);
		
	}
}
