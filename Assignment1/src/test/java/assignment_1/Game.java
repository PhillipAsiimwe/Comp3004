package assignment_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		Game game;
		String Choice;
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to BlackJack, How would you like to play? ('c' console or 'f' File input)");
		boolean flag= true;
		while(flag) {
		Choice = in.nextLine();
		if (Choice.equalsIgnoreCase("c")) {
			//Console();
			System.out.println("Whats your name?");
			Choice= in.nextLine();
			game = new Game(Choice);
			System.exit(0);
		}else if (Choice.equalsIgnoreCase("f")){
			System.out.println("Ok, please make sure the .TXT file is in '/Assignment_1/src/main/resources'");
			System.out.println("What is the File  name?");
			String name= in.nextLine();
			String Path = "C:\\Users\\phlli\\OneDrive\\Documents\\Fall 2018\\Comp3004\\Assignment1\\src\\main\\resources\\"+name+".txt" ;
			File file = new File(Path);
			Scanner sc = null;
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String [] commands = line.split(" ");
				game= new Game(commands);
				
			}
			
		}else {  
			System.out.println("Sorry I dont know your input method for this BlackJack game");
			flag = true;
		}

	}
}
	
	public Game(String b) {
		start(b);
		setPlayer(player);
		setPlayer(dealer);
		console();
	
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
	public void done() {
		
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
//				((Dealer)p).Decide();
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
		p.setFinished();
		
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
				
			}
			decide(player);
			decide(dealer);
		}
	}
	public void split(Person a) {
		a.split();
	}
	
	public void hit(Person c) {
		if (c.getvalue(1)<=21) {
			Deal(c);
			
		}else {
			System.out.println("Cant hit Total too high ");
			c.bust1();
		}
		if (c.isSplit()) {
			if (c.getvalue(2)<=21) {
				Deal(c);
			}else {
				System.out.println("Cant hit Total too high ");
				c.bust2();
				
			}
		}
		
	}
	public void decide(Person a) {
		if (a.isSplit()) {
			if (a.getvalue(1)>21) {
				a.bust1();
			}else if (a.getvalue(2)>21) {
				a.bust2();
			}
		}else if (a.getvalue(1)>21) {
			System.out.println("***bust**** ");
		}
	}
	

}