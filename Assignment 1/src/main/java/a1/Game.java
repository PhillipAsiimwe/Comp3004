package a1;

import java.util.ArrayList;

public class Game {
	private ArrayList<Card> Deck;
	
	public Game(String type) {
		initializeDeck();
		if (type.equalsIgnoreCase("f")) {
			
		}else if (type.equalsIgnoreCase("c")) {
			
		}
	}
	public void initializeDeck() {
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
