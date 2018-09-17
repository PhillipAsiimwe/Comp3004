package a1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cards {
	private static final HashMap<String,String> suits = (HashMap<String, String>) fillsuits();
	private static final HashMap<String,String> Rank= (HashMap<String, String>) fillranks();
	private ArrayList<Card> Deck;
	
	public Cards() {

		
	}
	public String toStrng() {
		
		return null;
	}

	
	
	
	
	
	
	private static Map<String,String> fillsuits() {	//initialize the Cards.
		Map <String,String> suit = new HashMap<String,String>();
		suit.put("H","Hearts");
		suit.put("S", "Spades");
		suit.put("C","Clubs");
		suit.put("D", "Diamonds");
		return suit;
	}
	private static Map<String,String> fillranks(){
		Map<String,String> Rank = new HashMap<String,String>();
		Rank.put("A", "ACE");
		Rank.put("2", "TWO");
		Rank.put("3", "THREE");
		Rank.put("4", "FOUR");
		Rank.put("5", "FIVE");
		Rank.put("6", "SIX");
		Rank.put("7", "SEVEN");
		Rank.put("8", "EIGHT");
		Rank.put("9", "NINE");
		Rank.put("10", "TEN");
		Rank.put("J", "JACK");
		Rank.put("Q", "QUEEN");
		Rank.put("K", "KING");
		return Rank;
	}
}
