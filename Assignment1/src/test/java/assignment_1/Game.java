package assignment_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Game {
	private Stack <Card> Deck;
	private Set<Card> Used = new HashSet<Card>();
	private Player player;
	private Dealer dealer;
	boolean shuffled = false; 
	
	public Game(String b) {
		start(b);
		setPlayer(player);
		setPlayer(dealer);
	
	}
	public Game(String [] a) {
		start("NON");
		player.addCard(new Card(a[0]));
		player.addCard(new Card(a[1]));
		dealer.addCard(new Card(a[2]));
		dealer.addCard(new Card(a[3]));
		for (int i=4 ;i<a.length;i++) {
			if (a[i].equals("S")) {
				//stand
			}else if(a[i].equals("H")) {
				//hit
			}else if (a[i].equals("D")) {
				if (player.canSplit()) {
					//split
				}else {
					//dont 
				}
			}else {
				if (a[i].length()<2) {
					dealer.addCard(new Card(a[i]));
				}else {
					System.out.println("Can not do operations");
				}
			}
		}
		
		
	}
	public void shuffleDeck() {
		if (Deck.isEmpty()) {
			initializeDeck();
		}
		Collections.shuffle(Deck);
		shuffled=true;
		
	}
	public Stack <Card> getDeck(){
		return Deck;
	}
	public Card getpop() {
		return Deck.pop();
	}
	public void setPlayer(Person a) {
		if (!shuffled) {
			shuffleDeck();
		}
		for (int i = 0;i<2;i++) {
			Deal(a);
		}		
		if ( a instanceof Dealer) {
			dealer= (Dealer) a; 
			dealer.setfirstcard(dealer.getFirst());
			System.out.println("Dealer");
		}else {
			player = (Player) a; 
			System.out.println("Player");
		}		
	}
	
	public void Hit(Person p) {
		if(p.getHand().size()<2) {
			System.out.println("Cant Hit yet");
		}else {
			if( p instanceof Dealer) {
				((Dealer)p).Decide();
			}else {
				Deal(p);					
			}
			
		}
		
	}
	public void Hit(Person p,String s) {
		if(p.getHand().size()<2) {
			System.out.println("Cant Hit yet");
		}else {
			
		}
		
	}
	public void stand(Person p) {
		
	}

	public void initializeDeck() {
		Deck = new Stack<Card>();
		String [] suit = new String[] {"H","S","C","D"};
		String [] rank = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String a:suit) {
			for (String b:rank) {
				Deck.add(new Card(a,b));
			}
		}
	}
	public void Deal(Person a) {
		Card toadd ;
		toadd=Deck.pop();
		if (!Used.contains(toadd)) {
		Used.add(toadd);
		a.addCard(toadd);
		}else {
			System.out.println("Couldnt Deal");
		}
	}
	public int getdecksize() {
		return Deck.size();
	}
	public void start(String a) {
		initializeDeck();
		shuffleDeck();
		if (a.equals("NON")) {player = new Player();}else {player = new Player(a);}
		dealer= new Dealer("Mike");
	}

}