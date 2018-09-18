package assignment_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BlackJackTest {

	public void testDeck() {
		Player testp = new Player();
		Game test = new Game("n");
		//test.shuffleDeck();
		assertEquals(51,test.getdecksize());
		System.out.println(test.getdecksize());
		
	}
	public void testgetvalue() {// tests Loop and getvalue
		Card test = new Card("H","A");
		assertEquals(11, test.getvalue(false));
		assertEquals(1, test.getvalue(true));
		test = new Card("H","2");
		assertEquals(2, test.getvalue(false));
		test = new Card("H","3");
		assertEquals(3, test.getvalue(false));
		test = new Card("H","4");
		assertEquals(4, test.getvalue(false));
		test = new Card("H","5");
		assertEquals(5, test.getvalue(false));
		test = new Card("H","6");
		assertEquals(6, test.getvalue(false));
		test = new Card("H","7");
		assertEquals(7, test.getvalue(false));
		test = new Card("H","8");
		assertEquals(8, test.getvalue(false));
		test = new Card("H","9");
		assertEquals(9, test.getvalue(false));
		test = new Card("H","10");
		assertEquals(10, test.getvalue(false));
		test = new Card("H","J");
		assertEquals(10, test.getvalue(false));
		test = new Card("H","Q");
		assertEquals(10, test.getvalue(false));
		test = new Card("H","K");
		assertEquals(01, test.getvalue(false));
	}
	public void testaddCard() {
		Player test = new Player();
		test.addCard("H", "4");
		test.addCard("C", "J");
		test.addCard("H", "A");
		test.addCard("D", "2");
		test.addCard("C", "A");
		System.out.print(test.toString());
		System.out.println(test.getvalue());
	}
	

}
