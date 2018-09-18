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
	public String toString() {
		String test;
		test="Dealer: "+ super.getname() +" Has \n";
		test += super.toString();
		return test;
				
		
	}
	public void Decide() {
		
	}

}
