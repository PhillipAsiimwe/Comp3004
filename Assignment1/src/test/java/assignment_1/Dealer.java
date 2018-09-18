package assignment_1;

public class Dealer extends Player {
	private Card firstCard;
	public Dealer() {
		super();
	}
	public Dealer(String nme) {
		super(nme);
	}
	public void setfirstcard(Card a) {
		firstCard= a;
	}
	public Card getFirst() {
		return super.getHand().get(0);
	}
//	public String toString() {
//		
//		
//		return null;
//		
//	}

}
