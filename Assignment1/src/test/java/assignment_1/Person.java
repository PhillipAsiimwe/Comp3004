package assignment_1;

import java.util.ArrayList;

public abstract class Person {
	private ArrayList<Card> inHnd = new ArrayList<Card>();
	private String name;
	private Card firstCard;

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
	public String toString() {
		String Text="";
		for (Card a: inHnd) {
			if (this instanceof Dealer && a.equals(firstCard)) {
				Text += "**HIDDEN**\n";
			}else {
			Text+= a.toString() + "\n";
			}
		}
		return Text;
	}

}