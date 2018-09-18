package assignment_1;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> inHnd = new ArrayList<Card>();
	private String name;
	boolean Ace = false;
	public Player() {
		this("Testplayer");
	}
	public Player(String nme) {
		name = nme;
	}
	public int getvalue() {
		boolean ace = false;
		int total=0;
		for (Card a :inHnd) {
			total += a.getvalue(ace);
			if (a.getrank().equals("ACE")) {
				ace = true;
			}
		}
		return total;
	}
	public void addCard(Card c) {
		inHnd.add(c);
	}
	
	public void addCard(String a,String b) {
		Card addtohand=new Card(a,b);
		inHnd.add(addtohand);
	}
	public void emptyhnd() {
		inHnd = new ArrayList<Card>();
	}
	public ArrayList<Card> getHand(){
		return inHnd;
	}
	public String toString() {
		String test;
		test="Player: "+ name +" Has \n";
		for (Card a: inHnd) {
			test+= a.toString() + "\n";
		}
		return test;
				
	}

}