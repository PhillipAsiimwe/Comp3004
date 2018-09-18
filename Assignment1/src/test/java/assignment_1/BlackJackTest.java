package assignment_1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class BlackJackTest extends TestCase {

	
	public void testDone() {
		Player testp = new Player();
		Dealer Testd = new Dealer();
		Card temp = new Card("SJ");
		Card temp1 = new Card("H10");
		
	}
	
	
	public void testCard() {
		Card temp = new Card("SJ");
		Card temp1 = new Card("H10");
		System.out.println(temp.toString());
		System.out.println(temp1.toString());
	}
	
	public void testHit() {
		Player testp = new Player();
		Game testenv = new Game("c");
		testenv.setPlayer(testp);
		testenv.Hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		assertEquals(true,testenv.isbust(testp));
		
	}
	
	public void testsplitting() {
		Dealer Testd = new Dealer("Noah");
		Player Testp = new Player("Time");
		Card temp1 = new Card ("H","2");
		Card temp2 = new Card ("D","2");
		Card temp3 = new Card ("D","3");
		Testd.addCard(temp1);
		Testd.addCard(temp2);
		Testp.addCard(temp1);
		Testp.addCard(temp3);
		assertEquals(true, Testd.canSplit());
		assertEquals(false,Testp.canSplit());
		
		
	}
	
	public void testDealer() {
		Dealer testd= new Dealer("Mike");
		Player testp = new Player("Phill");
		Game test = new Game("n");
		test.setPlayer(testd);
		test.setPlayer(testp);
		System.out.println(testd.toString());
		System.out.println(testp.toString());

	}

	public void testDeck() {
		Player testp = new Player();
		Game test = new Game("n");
		boolean same = false;
		int count=0;
		ArrayList<Card> testArray = new ArrayList<Card>(test.getDeck());
		test.shuffleDeck();
		ArrayList<Card> testArray2= new ArrayList<Card>(test.getDeck());
		for (int i =0; i<testArray.size();i++) {
			if (testArray.get(i).equals(testArray2.get(i))) {
				count++;
			}
		}
		if (count==testArray.size()) {
			same=true;
		}
		System.out.println(testArray.toString());
		System.out.println(testArray2.toString());
		
		//test.shuffleDeck();
		assertEquals(52,test.getdecksize());
		assertEquals(false,same);
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
		assertEquals(10, test.getvalue(false));
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
