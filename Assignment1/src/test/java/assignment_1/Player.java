package assignment_1;

import java.util.ArrayList;

public class Player extends Person{
	public Player() {super();}
	public Player(String nme) {super(nme);}
	public int getvalue(int a) {return super.getvalue(a);}
	
	public void addCard(Card c) {super.addCard(c);}
	
	public void addCard(String a,String b) {super.addCard(a, b);}
	
	public void emptyhnd() {super.emptyhnd();}
	
	public ArrayList<Card> getHand(){return super.getHand();}
	

	public String toString() {
		String test;
		test="Player: "+ super.getname() +" Has \n";
		test+=super.toString();
		return test;
				
	}

}