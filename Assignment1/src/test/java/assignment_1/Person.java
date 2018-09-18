package assignment_1;

import java.util.ArrayList;

public abstract class Person {
	private ArrayList<Card> inHnd = new ArrayList<Card>();
	private String name;
	private Card firstCard;
	private boolean finished = false; 

	public Person() {
		this("Testplayer");
	}
	public Person(String nme) {
		name=nme;
	}
	public String getname() {
		return name;
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
	public void setfirstcard(Card a) {
		firstCard= a;
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
	public void finsihed() {
		finished=true;
	}
	public boolean canSplit() {
		boolean temp;
		ArrayList<Card> hand = this.getHand();
		if (hand.size()==2 &&(hand.get(0).getrank().equals(hand.get(1).getrank()))){
			temp = true;
		}else {
			temp=false;
		}
		return temp;
	}
	public String toString() {
		String Text="";
		for (Card a: inHnd) {
			if (this instanceof Dealer && a.equals(firstCard)&& !finished) {
				Text += "**HIDDEN**\n";
			}else {
			Text+= a.toString() + "\n";
			}
		}
		return Text;
	}

}
