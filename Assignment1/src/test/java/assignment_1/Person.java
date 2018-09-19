package assignment_1;

import java.util.ArrayList;

public abstract class Person {
	private ArrayList<Card> inHnd = new ArrayList<Card>();
	private ArrayList<Card> inHnd2= new ArrayList<Card>();
	private String name;
	private Card firstCard;
	private boolean bust1 = false;
	private boolean bust2 = false;

	private boolean finished = false; 
	private boolean isSplit = false;

	public Person() {
		this("Testplayer");
	}
	public Person(String nme) {
		name=nme;
	}
	public String getname() {
		return name;
	}
	public int getvalue(int c) {
		boolean ace = false;
		int total=0;
		if(c == 1) {
		for (Card a :inHnd) {
			total += a.getvalue(ace);
			if (a.getrank().equals("ACE")) {
				ace = true;
			}
		}
		}else {
			for (Card b :inHnd2) {
				total += b.getvalue(ace);
				if (b.getrank().equals("ACE")) {
					ace = true;
				}
			}
			
		}
		return total;
	}
	public void addCard(Card c) {
		if (bust1) {
			inHnd2.add(c);
		}else {
		inHnd.add(c);
		}
	}
	public void setfirstcard(Card a) {
		firstCard= a;
	}
	public void bust1() {
		bust1 = true;
		setFinished();
	}
	public void bust2() {
		bust2=true;
		setFinished();
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
	public boolean isFinsihed() {
		return finished;
	}
	public void setFinished() { finished=true;
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
	public void split() {
		System.out.println("Before " +inHnd.toString());
		inHnd2.add(inHnd.remove(1));
		System.out.println("After " +inHnd.toString());
		System.out.println("second hand " +inHnd2.toString());
		isSplit = true;
	}
	public boolean isSplit() {
		return isSplit;
	}
	public ArrayList<Card> get2ndHnd(){
		return inHnd2;
	}
	public boolean isbust1() {
		return bust1;
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
		if (this instanceof Dealer&& !finished) {
		Text+="Total:?\n";
		}else {
			Text+="Total: "+getvalue(1)+"\n";

		}
		if (isSplit) {
			for (Card ab: inHnd2) {
				if (this instanceof Dealer && ab.equals(firstCard)&& !finished) {
					Text += "**HIDDEN**\n";
				}else {
				Text+= ab.toString() + "\n";
				}
			}
			if (this instanceof Dealer && !finished) {
				Text+="Total:?\n";
				}else {
					Text+="Total: "+getvalue(2)+"\n";

		}
	}
		return Text;


}

}