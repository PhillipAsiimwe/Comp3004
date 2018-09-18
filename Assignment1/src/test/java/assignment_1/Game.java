package assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Game {
	private Stack <Card> Deck;
	private Set<Card> Used = new HashSet<Card>();
	private Player player;
	private Dealer dealer;
	boolean shuffled = false; 
	
	public Game(String type) {
		initializeDeck();
		if (type.equalsIgnoreCase("f")) {
			
		}else if (type.equalsIgnoreCase("c")) {
			
		}
	}
	public void shuffleDeck() {
		if (Deck.isEmpty()) {
			initializeDeck();
		}
		Collections.shuffle(Deck);
		shuffled=true;
		
	}
	public Stack <Card> getDeck(){
		return Deck;
	}
	public Card getpop() {
		return Deck.pop();
	}
	public void setPlayer(Dealer a) {
		if (!shuffled) {
			shuffleDeck();
		}
		Card toadd ;
		for (int i = 0;i<2;i++) {
			toadd=Deck.pop();
			Used.add(toadd);
			a.addCard(toadd);
		}		
		if ( a instanceof Dealer) {
			dealer= a; 
			dealer.setfirstcard(dealer.getFirst());
			System.out.println("Dealer");
		}else {
			player = a; 
			System.out.println("Player");
		}		
	}

	public void initializeDeck() {
		Deck = new Stack<Card>();
		String [] suit = new String[] {"H","S","C","D"};
		String [] rank = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String a:suit) {
			for (String b:rank) {
				Deck.add(new Card(a,b));
			}
		}
	}
	public int getdecksize() {
		return Deck.size();
	}

}