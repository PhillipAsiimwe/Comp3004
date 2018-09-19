package assignment_1;

import java.util.ArrayList;

public class Dealer extends Person {
	public Dealer() {
		super();
	}
	public Dealer(String nme) {
		super(nme);
	}
	public void setfirstcard(Card a) {
		super.setfirstcard(a);
	}
	public Card getFirst() {
		return super.getHand().get(0);
	}
	public boolean isSoft17() {
		ArrayList<Card> temp = super.getHand();
		for(Card a:temp) {
			if (a.getrank().equals("ACE")) {
				return true; 
			}
		}
		if(super.isSplit()) {
			temp = super.get2ndHnd();
			for(Card a:temp) {
				if (a.getrank().equals("ACE")) {
					return true; 
				}
			}
		}
		return false; 
		
	}
	
	public String toString() {
		String test;
		test="Dealer: "+ super.getname() +" Has \n";
		test += super.toString();
		return test;	
	}

}
