package a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlackjackTest {
	
	public void testDeck() {
		Player testp = new Player();
		Game test = new Game("n");
		//test.shuffleDeck();
		assertEquals(51,test.getdecksize());
		System.out.println(test.getdecksize());
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
