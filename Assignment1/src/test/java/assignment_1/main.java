package assignment_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Game game;
		String Choice;
		Scanner in = new Scanner (System.in);
		System.out.println("Welcome to BlackJack, How would you like to play? ('c' console or 'f' File input)");
		boolean flag= true;
		boolean error=false;
		while(flag) {
		Choice = in.nextLine();
		if (Choice.equalsIgnoreCase("c")) {
			//Console();
			System.out.println("Whats your name?");
			Choice= in.nextLine();
			game = new Game(Choice);
			System.exit(0);
		}else if (Choice.equalsIgnoreCase("f")){
			error=false;
			System.out.println("Ok, please make sure the .TXT file is in '/Assignment_1/src/main/resources'");
			System.out.println("What is the File  name?");
			String name= in.nextLine();
			String Path = "C:\\Users\\phlli\\OneDrive\\Documents\\Fall 2018\\Comp3004\\Assignment1\\src\\main\\resources\\"+name+".txt" ;
			File file = new File(Path);
			Scanner sc = null;
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("e.printStackTrace():File Doesnt Exist");
				error = true;
			}
			if(!error) {
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String [] commands = line.split(" ");
					game= new Game(commands);
					
				}
			
			}
			
		}else {  
			System.out.println("Sorry I dont know your input method for this BlackJack game");
			flag = true;
		}

	}
}

}
