package assignment_1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Game {
	private Stack <Card> Deck;
	private Set<Card> Used = new HashSet<Card>();
	private Player player;
	private Dealer dealer;
	boolean shuffled = false; 
	boolean gameover = false;

	public Game () {
		initializeDeck();
		shuffleDeck();
	}
	public Game(String b) {
		start(b);
		setPlayer(player);
		setPlayer(dealer);
		console();
	
	}
	public Game(String [] a) {
		start("NON");//Starts game off files
		player.addCard(new Card(a[0]));
		player.addCard(new Card(a[1]));
		dealer.addCard(new Card(a[2]));
		dealer.addCard(new Card(a[3]));
		if (dealer.canSplit()) {
			dealer.split();
		}
		System.out.println(player.toString());
		System.out.println(dealer.toString());
		boolean isdealer=false;
		for (int i=4 ;i<a.length;i++) {
			if (a[i].equals("S")) {
				//stand
				stand(player);
				if(player.isSplit()&& !isdealer) {
					i++;
					Hit(player,a[i]);
					isdealer=true;
				}
				System.out.println(player.toString());
				System.out.println(dealer.toString());
				
			}else if(a[i].equals("H")) {
				i++;
				Hit(player,a[i]);
				System.out.println(player.toString());
				System.out.println(dealer.toString());


			}else if (a[i].equals("D")) {
				if (player.canSplit()) {
					//split
					i++;
					player.split();
					Hit(player,a[i]);
					System.out.println(player.toString());
					System.out.println(dealer.toString());


				}else {
					System.out.println("Sorry you cant split");
					//dont 
				}
			}else {
				if (a[i].length()<=2) {
					dealer.addCard(new Card(a[i]));
					decide(dealer);
					System.out.println(dealer.toString());

				}else {
					System.out.println("Can not do operations");
					System.out.println(player.toString());
					System.out.println(dealer.toString());
					System.out.println(a[i]);

				}
			}
		}
		done();
		
	}
	public void done() {
		player.setFinished();
		dealer.setFinished();
		System.out.println(player.toString());
		System.out.println(dealer.toString());
		if (player.getvalue(1)==21 && dealer.getvalue(1)==21) {
			System.out.println("BlackJack Dealer Wins");
		}else if (player.getvalue(1)==21) {
			System.out.println("BlackJack player Wins");
		}
		else if (dealer.getvalue(1)==21) {
			System.out.println("BlackJack Dealer Wins");
		}else if (player.Best()>dealer.Best()) {
			System.out.println("Player Wins");
		}else if (player.Best()<dealer.Best()) {
			System.out.println("Dealer Wins");
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
		if (a.getHand().size()==0) {
			for (int i = 0;i<2;i++) {
				Deal(a);
			}		
		}
		if ( a instanceof Dealer) {
			dealer= (Dealer) a; 
			dealer.setfirstcard(dealer.getFirst());
		}else {
			player = (Player) a; 
		}	
		System.out.println(a.toString());
	}	
	public void Hit(Person p,String s) {
		if (!gameover) {
		if(p.getHand().size()<2 && !p.isSplit()) {
			System.out.println("Cant Hit yet");
		}else {
			if (!p.isbust1()) {
			System.out.println("HITIT");
			Card c = new Card(s);
			Used.add(c);
			Deck.remove(c);
			p.addCard(c);
			}else if (p.isbust1()){
				System.out.println("HITIT");
				Card c = new Card(s);
				Used.add(c);
				Deck.remove(c);
				p.addCard(c);
				}else {
				System.out.println("over here ");
				System.out.println(s);
			}
			
			
		}
		this.decide((Player)p);
		}else {
			System.out.println("GAme over");
		}
		
	}
	public void stand(Person p) {
		if(!gameover){
			if (p.isSplit()) {
				p.bust1();
			}else {
				p.setFinished();
			}
		}else {
			System.out.println("Game Over Stand");
		}
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
		}
	}
	public int getdecksize() {
		return Deck.size();
	}
	public void start(String a) {
		initializeDeck();
		shuffleDeck();
		if (a.equals("NON")) {player = new Player();}else {player = new Player(a);}
		dealer= new Dealer("Mike the Dealer");
	}
	public void console() {
		String answer=null;
		Scanner sc = new Scanner(System.in);
		while(!player.isFinsihed() || !dealer.isFinsihed()) {
			if (!player.isFinsihed()) {
				System.out.println(player.toString());
				System.out.println(player.getname() +" would you like to Hit (H) or stand (S)");
				if (player.canSplit()) {
					System.out.println("You can also split (D)");
				}
				answer=sc.nextLine();
				if (answer.equalsIgnoreCase("H")) {
					hit(player);
				}else if (answer.equalsIgnoreCase("S")) {
					stand(player);
				}else if  (player.canSplit()&& answer.equalsIgnoreCase("D")){
					split(player);
				}else {
					System.out.println("Sorry wrong command");
				}
				
			}else if (!dealer.isFinsihed()) {
				System.out.println(dealer.toString());
				play(dealer);
			}
			decide(player);
			decide(dealer);
		}
		done();
	}
	public void play(Dealer a) {
		if (a.getvalue(1)<17) {// test 
			Hit(a,"SA");//just for test if 
			//hit(a);
		}else if (a.getvalue(1)==17) {
			if (a.isSoft17()) {
				System.out.println("**SOFT 17**");
				hit(a);
			}
		}else {
			stand(a);
		}
		if (a.isSplit()) {
			if (a.getvalue(2)<17) {
				hit(a);
			}else if (a.getvalue(2)==17) {
				if (a.isSoft17()) {
					System.out.println("**SOFT 17**");
					hit(a);
				}
			}else {
				stand(a);
			}
			
		}
	}
	public void split(Person a) {
		a.split();
	}
	
	public void hit(Person c) {
		if (!gameover) {
		if (c.getvalue(1)<21) {
			Deal(c);
		}else {
			System.out.println("Cant hit Total too high ");
			c.bust1();
		}
		if (c.isSplit() && c.isbust1()) {
			if (c.getvalue(2)<21) {
				Deal(c);
			}else {
				System.out.println("Cant hit Total too high ");
				c.bust2();
			}
		}
		}
		
	}
	
	public void decide(Person a) {
		if (a instanceof Player) {
			if (a.getvalue(1)>21) {
				System.out.println("***Player bust1***");
				System.out.println(player.toString());
				a.bust1();
				if (!a.isSplit()) {
					a.setFinished();
				}
			}else if (a.getvalue(1)==21) {
				System.out.println("***BlackJack Player Wins From 1st Hand***");
				System.out.println(player.toString());
				a.setFinished();
			}
			if (a.isSplit()) {
				if (a.getvalue(2)>21) {
					System.out.println("***Player bust2**** ");
					System.out.println(player.toString());
					a.bust2();
					a.setFinished();
				}else if (a.getvalue(2)==21) {
					System.out.println("***BlackJack Player Wins From 2st Hand***");
					System.out.println(player.toString());
					a.setFinished();
				}
			}
			
			
		}else if (a instanceof Dealer) {
			if (!a.isSplit()) {
				if (a.getvalue(1)>21) {
					System.out.println("***Dealer bust1***");
					System.out.println(dealer.toString());
					gameover=true;
				}else if (a.getvalue(1)==21) {
					System.out.println("***BlackJack Dealer Wins From 1st Hand***");
					System.out.println(dealer.toString());
					gameover=true;
				}
				if (a.isSplit()) {
					if (a.getvalue(2)>21) {
						System.out.println("***Dealer bust2**** ");
						System.out.println(dealer.toString());
						a.bust2();
						gameover=true;

					}else if (a.getvalue(2)==21) {
						System.out.println("***BlackJack Dealer Wins From 2st Hand***");
						System.out.println(dealer.toString());
						gameover=true;
					}
				}
				
		}
		
	}
	}
}

	
