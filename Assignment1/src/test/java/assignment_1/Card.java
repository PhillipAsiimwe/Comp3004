package assignment_1;
import java.util.HashMap;
import java.util.Map;

public class Card {
	private static final HashMap<String,String> Suits = fillsuits();
	private static final HashMap<String,String> Rank= fillranks();
	private String suit,rank;
	public String getsuit() {return suit;}
	public String getrank() {return rank;}
	
	
	public Card(String a) {
		this(a.substring(0, 1),a.substring(1));
			}
	public Card(String a,String b) {
		if (Suits.containsKey(a)&& Rank.containsKey(b)) {
			suit=Suits.get(a);
			rank = Rank.get(b);
		}else {
			System.out.println("Card doesnt exist");
		}
		
	}

	public int getvalue(boolean Ace) {
		int value=0;
		String [] values= new String[] {"Null","ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN"};//used to figure out value of said Card
		if (rank.equals("ACE")) {
			if (Ace) {
				value = 1; 
			}else {
				value = 11;
			}
		}else if(rank.equals("JACK") ||rank.equals("QUEEN")||rank.equals("KING") ) {
			value= 10;
		}else {
			for (int i=0;i<values.length;i++) {
				if(rank.equals(values[i])) {
					value=i;
				}
			}
		}
		if (value==0) {
			System.out.println("value not found ");
		}
		return value;
	}
	
	public String toString() {
		return rank +" of "+ suit;
	
	}

	
	
	
	
	
	
	private static HashMap<String,String> fillsuits() {	//initialize the Cards.
		Map <String,String> suit = new HashMap<String,String>();
		suit.put("H","Hearts");
		suit.put("S", "Spades");
		suit.put("C","Clubs");
		suit.put("D", "Diamonds");
		return (HashMap<String, String>) suit;
	}
	private static HashMap<String,String> fillranks(){//initialize the Cards 
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
		return (HashMap<String, String>) Rank;
	}

}