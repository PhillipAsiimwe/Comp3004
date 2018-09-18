package assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Game {
	private Stack <Card> Deck;
	
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
		
	}
	public Stack <Card> getDeck(){
		return Deck;
	}
	public Card getpop() {
		return Deck.pop();
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