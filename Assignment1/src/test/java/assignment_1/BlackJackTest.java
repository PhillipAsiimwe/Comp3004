package assignment_1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class BlackJackTest extends TestCase {
	public void testSame() {
		System.out.println("***testSame***");// sees whats outputted when the cards are the same. 
		Game testenv = new Game();
		Player testp = new Player ();
		Dealer testd = new Dealer ();
		testp.addCard(new Card("SA"));
		testp.addCard(new Card("D9"));
		testd.addCard(new Card("DA"));
		testd.addCard(new Card("S9"));
		testenv.setPlayer(testd);
		testenv.setPlayer(testp);
		testenv.done();
		// tests after splitting
		testenv = new Game();
		testp = new Player();
		testd = new Dealer();
		testp.addCard(new Card("S2"));
		testp.addCard(new Card("D2"));
		testp.split();
		testp.addCard(new Card("SA"));
		testd.addCard(new Card("H2"));
		testenv.setPlayer(testd);
		testenv.setPlayer(testp);
		testenv.done();
		
	}
	public void testWinInstantly() {
		System.out.println("***testWinInstantly***");
		Game game = new Game();
		Dealer y = new Dealer();
		Player p = new Player();
		p.addCard(new Card("SA"));
		p.addCard(new Card("DQ"));
		y.addCard(new Card("H4"));
		y.addCard(new Card("D4"));
		game.setPlayer(p);
		game.decide(p);// should print that player won
		game.hit(p);//should allow 
		game.hit(y);
		y.addCard(new Card("S10"));
		y.addCard(new Card("S6"));
		game.setPlayer(y);
		game.play(y);//shouldnt make soft 17 
		System.out.println(y.toString());
		game.decide(y);//Should print the dealer won
		game.hit(y);
		
	}
	public void testDecide() {
		System.out.println("***testDecide***");
		Game game = new Game();
		Dealer y = new Dealer();
		Player g = new Player();
		//Want to check if decide will know when to finish on a bust
		g.addCard(new Card("S10"));
		g.addCard(new Card("HQ"));
		g.addCard(new Card("DA"));
		game.setPlayer(g);
		game.decide(g);//should print out Bust
		y.addCard(new Card("SA"));
		y.addCard(new Card("DA"));
		y.split();
		y.addCard(new Card("S9"));
		y.addCard(new Card("DQ"));
		y.addCard(new Card("C5"));
		y.addCard(new Card("C6"));// doesnt go in the second array **Fixed**
		game.setPlayer(y);
		game.decide(y);
		
	}
	public void testgetvalueAce() {
		System.out.println("***testgetvalueAce***");
		Game game = new Game();
		Player p= new Player();
		p.addCard(new Card("H4"));
		p.addCard(new Card("S4"));
		p.addCard(new Card("HA"));
		p.addCard(new Card("SA"));
		game.setPlayer(p);
		System.out.println(p.toString());
		
	}
	public void testisSoft17() {
		System.out.println("***testisSoft17***");
		Dealer testd = new Dealer();
		Player testp = new Player();
		Game testenv= new Game();
		testd.addCard(new Card("HA"));
		testd.addCard(new Card("S5"));
		testd.addCard(new Card("SA"));
		testenv.setPlayer(testd);
		testenv.setPlayer(testp);
		testenv.console();
		System.out.println(testd.toString());
		
	}

	
	public void testSplitting() {
		System.out.println("***testSplitting***");

		Player testp = new Player();
		Dealer Testd = new Dealer();
		Card temp = new Card("SA");
		Card temp1 = new Card("HA");
		testp.addCard(temp);
		testp.addCard(temp1);
		System.out.println(testp.toString());
		Game testenv = new Game();
		testenv.setPlayer(testp);
		testenv.split(testp);
		System.out.println(testp.toString());
		testenv.Hit(testp, "S6");
		testenv.Hit(testp, "H10");
		testenv.Hit(testp,"H2");
		System.out.println(testp.toString());
		
	}
	
	
	public void testCard() {
		System.out.println("***testCard***");

		Card temp = new Card("SJ");
		Card temp1 = new Card("H10");
		System.out.println(temp.toString());
		System.out.println(temp1.toString());
	}
	
	public void testHit() {
		System.out.println("***testHit***");

		Player testp = new Player();
		Game testenv = new Game("c");
		testenv.setPlayer(testp);
		//testenv.Hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		testenv.hit(testp);
		//assertEquals(true,testenv.isbust(testp));
		
	}
	
	public void testsplitting() {
		System.out.println("***testsplitting***");

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
		System.out.println("***testDealer***");

		Dealer testd= new Dealer("Mike");
		Player testp = new Player("Phill");
		Game test = new Game("n");
		test.setPlayer(testd);
		test.setPlayer(testp);
		System.out.println(testd.toString());
		System.out.println(testp.toString());// shows initial cards shown for player 

	}
	
	public void testDeck() {
		System.out.println("***testDeck***");

		Player testp = new Player();
		Game testenv = new Game();
		testenv.shuffleDeck();
		assertEquals(52,testenv.getdecksize());// tests size of Deck
		
	}
	public void testgetvalue() {// tests Loop and getvalue
		System.out.println("***testgetvalue***");

		Card test = new Card("H","A");
		assertEquals(1, test.getvalue());
		test = new Card("H","2");
		assertEquals(2, test.getvalue());
		test = new Card("H","3");
		assertEquals(3, test.getvalue());
		test = new Card("H","4");
		assertEquals(4, test.getvalue());
		test = new Card("H","5");
		assertEquals(5, test.getvalue());
		test = new Card("H","6");
		assertEquals(6, test.getvalue());
		test = new Card("H","7");
		assertEquals(7, test.getvalue());
		test = new Card("H","8");
		assertEquals(8, test.getvalue());
		test = new Card("H","9");
		assertEquals(9, test.getvalue());
		test = new Card("H","10");
		assertEquals(10, test.getvalue());
		test = new Card("H","J");
		assertEquals(10, test.getvalue());
		test = new Card("H","Q");
		assertEquals(10, test.getvalue());
		test = new Card("H","K");
		assertEquals(10, test.getvalue());
	}
	public void testAce() {// test to make sure ACE is 11 and 1 at the right instance after changing return arguments and parameters. 
		System.out.println("***testAce***");

		Player test = new Player();
		test.addCard(new Card("SA"));
		assertEquals(11, test.getvalue(1));
		test.addCard(new Card("HA"));
		assertEquals(12, test.getvalue(1));
		Player test2 = new Player();
		test2.addCard(new Card("S10"));
		test2.addCard(new Card("DA"));
		assertEquals(21, test2.getvalue(1));
		test = new Player ();
		test.addCard(new Card("S10"));
		test.addCard(new Card("S5"));
		test.addCard(new Card("SA"));
		assertEquals(16, test.getvalue(1));
		test.addCard(new Card("DA"));
		test.addCard(new Card("HA"));
		assertEquals(18, test.getvalue(1));

		
	}
	public void testaddCard() {
		System.out.println("***testaddCard***");
		Player test = new Player();
		test.addCard("H", "4");
		test.addCard("C", "J");
		test.addCard("H", "A");
		test.addCard("D", "2");
		test.addCard("C", "A");
		System.out.print(test.toString());
		//System.out.println(test.getvalue());
	}
	

}
