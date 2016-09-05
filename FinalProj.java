package finalproject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class FinalProj {
	
	public static void baseMenu (Char player, Inventory playerInventory) {
		int menuChoice;
		Scanner scannerObj;
		String newName;
		int newAge;
		
		scannerObj = new Scanner(System.in);
		while (true) {
			System.out.println("");
			System.out.println("Actions: ");
			System.out.println("1: Change name. ");
			System.out.println("2: Change age. ");
			System.out.println("3: View inventory. ");
			System.out.println("4: Exit to main menu. ");
			
			menuChoice = scannerObj.nextInt();
			
			if (menuChoice == 1) {
				System.out.println("");
				System.out.println("What would you like your new name to be? ");
				newName = scannerObj.next();
				player.changeName(newName);
				player.sayHi();
				
			}
			
			else if (menuChoice == 2) {
				System.out.println("");
				System.out.println("What would you like your new age to be? ");
				newAge = scannerObj.nextInt();
				player.changeAge(newAge);
				player.sayAge();
				
			}
			
			else if (menuChoice == 3) {
				playerInventory.view();
			}
			
			else if (menuChoice == 4) {
				break;
			}
			
			else {
				System.out.println("That is not an option.");
			}
		}
	}
	
	public static void main (String[] args) {
		
		// initialize variables
		Char player;
		Inventory playerInventory;
		Riddle riddleObj;
		Scanner scannerObj;
		String playerName;
		int playerAge;
		int choice1;
		String choice2;
		String choice3;
		String rAns;
		
		String newName;
		int newAge;
		String[][] invArray;
		String[][] riddleArray;
		boolean win = false;
		double someDoub = 2.5;
		Random randomObj;
		int someNum;
		int tries = 2;
		int guess;
		int done;
		boolean l1Complete;
		boolean l2Complete;
		boolean l3Complete;
		boolean l4Complete;
		
		done = 0;
		l1Complete = false;
		l2Complete = false;
		l3Complete = false;
		l4Complete = false;
		
		
		// Define variables
		scannerObj = new Scanner(System.in);
		invArray = new String[10][2];
		riddleArray = new String[50][2];
		riddleObj = new Riddle (riddleArray);
				
		System.out.println("What is your name? ");
		playerName = scannerObj.nextLine();
		
		System.out.println("And what is your age? ");
		playerAge = scannerObj.nextInt();
		
		player = new Char (playerName, playerAge);
		playerInventory = new Inventory (invArray, player);
		
		player.sayHi();
		System.out.println("");
		player.sayAge();
		
		// riddle time!
		
		riddleObj.addNew("I don't have eyes, but once I did see. Once I had thoughts, but now I am white and empty.", "skull");
		riddleObj.addNew("If you have me, you want to share me. If you share me, you haven't got me. What am I?","secret");
		riddleObj.addNew("What disappears the moment you say its name?","silence");
		riddleObj.addNew("What is it that no man ever yet did see, which never was, but always is to be?","tomorrow");
		riddleObj.addNew("What object has keys that open no locks, space but no room, and you can enter but not go in?","keyboard");
		
		playerInventory.sayItemAmt();
		
		// main loop of game
		while (win == false) {
			System.out.println("");
			// some actions
			System.out.println("1: Menu");
			
			System.out.println("2: Begin first adventure.");
			if (l1Complete) {
				System.out.println("3: Begin second adventure. ");
			}
			
			if (l1Complete && l2Complete) {
				System.out.println("4: Begin third adventure. ");
			}
			
			if (l1Complete && l2Complete && l3Complete) {
				System.out.println("5: Begin final adventure. ");
			}
			
			if (l1Complete && l2Complete && l3Complete && l4Complete) {
				System.out.println("6: Win Game");
			}
			
			choice1 = scannerObj.nextInt();
			
			if (choice1 == 1) {
				baseMenu(player, playerInventory);
			}
			
			else if (choice1 == 2) {
				
				if (l1Complete) {
					System.out.println("");
					System.out.println("You have already completed that adventure.");
				}
				else {
					randomObj = new Random();
					someNum = randomObj.nextInt(10) + 1;
					
					while (tries >= 0) {
						System.out.println("");
						System.out.println("Guess a number between 1 and 10: ");
						guess = scannerObj.nextInt();
						 
						if (guess == someNum) {
							System.out.println("Correct! Nice job.");
							done = 1;
							break;
						}
						else if (guess < someNum) {
							System.out.println("Sorry. Your number is too low. ");
						}
						
						else if (guess > someNum) {
							System.out.println("Sorry. Your number is too high. ");
						}
						
						if (tries > 0) {
							 System.out.println("Try again (you have " + tries + " tries left) ");
						}
						
						tries -= 1;
					}
					if (done == 0) {
						System.out.println("You have run out of tries!");
						tries = 2;
					}
					
					else if (done == 1) { 
						System.out.println("");
						System.out.println("You have found a bronze trophy. Pick it up (Y/N)? ");
						choice2 = scannerObj.next();
						if (choice2.equals("Y") || choice2.equals("y")) {
							System.out.println("You pick up the trophy. ");
							playerInventory.newItem("Bronze Trophy");
							System.out.println("");
							System.out.println("You recieved a Bronze Trophy!");
							l1Complete = true;
						}
						if (choice2.equals("N") || choice2.equals("n")) {
							System.out.println("For some reason, you don't pick up the trophy. That was dumb.");
						}
						done = 0;
						tries = 2;
					}
				}
			}
			
			else if (choice1 == 3 && l1Complete) {
				System.out.println("");
				System.out.println("Let me ask you some riddles... You have 5 tries to answer 5 riddles.");
				for (int i = 0, rTries = 4, rComplete = 0; i < 5; i++, rTries--) {
					riddleObj.ask(i);
					rAns = scannerObj.next();
					
					if (rAns.equals(riddleObj.correct(i))) {
						rComplete++;
						System.out.println("You are correct! You have completed " + (rComplete) + " riddles and have " + (rTries) + " tries left.");
						
					}
					
					else {
						System.out.println("You are incorrect. You have completed " + (rComplete) + " riddles and have " + (rTries) + " tries left.");
					}
					
					if (rComplete == 5) {
						System.out.println("");
						System.out.println("You have found a Silver Trophy. Pick it up (Y/N)? ");
						choice3 = scannerObj.next();
						if (choice3.equals("Y") || choice3.equals("y")) {
							System.out.println("You pick up the trophy. ");
							playerInventory.newItem("Silver Trophy");
							System.out.println();
							System.out.println("You recieved a Silver Trophy!");
							l2Complete = true;
						}
						if (choice3.equals("N") || choice3.equals("n")) {
							System.out.println("For some reason, you don't pick up the trophy. That was dumb.");
						}
				
					}
					
					else if (rTries == 0 && rComplete < 5) {
						System.out.println("You have run out of tries...");
						System.out.println("Resetting progress...");
						playerInventory.remItem("Bronze Trophy");
						l1Complete = false;
						l2Complete = false;
					}
				}
			}
			
			else if (choice1 == 4 && l1Complete && l2Complete) {
				System.out.println("");
				System.out.println(" No adventure here yet! You win!");
				playerInventory.newItem("Gold Trophy");
				System.out.println("You recieved a Gold Trophy!");
				l3Complete = true;
			}
			
			else if (choice1 == 5 && l1Complete && l2Complete && l3Complete) {
				System.out.println("");
				System.out.println("No adventure here yet! You win!");
				playerInventory.newItem("Winners Medal");
				System.out.println("You recieved the Winners Medal!");
				l4Complete = true;
			}
			
			else if (choice1 == 6 && l1Complete && l2Complete && l3Complete && l4Complete) {
				win = true;
			}
			
			else {System.out.println("That is not an option.");}
		}
		System.out.println("");
		System.out.println("Congratulations, " + player.name + ", you Won!");
		
	}
	
}
