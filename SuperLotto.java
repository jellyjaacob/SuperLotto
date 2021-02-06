/* Super Lotto Plus is a California lottery game where if you match five lucky numbers 
 * from 1 to 47 and one MEGA number from 1 to 27, you can win millions. 
 * For more information visit calottery.com
 * @author Jacob Le
 * CS 108 - Section 1
 */


import java.util.Scanner; //imports a Scanner
import java.util.Random;	//imports a Random Number Generator
	

public class SuperLotto {
	
/* SuperLotto program that asks user for name, 
 * how many tickets they would buy, print results, 
 * and asks if they would like run program again. 	
 * @see calottery.com
 */
	
	public static void main (String arg [] ) {
		
		// Runs the program initially and after asks for user input if they would like to rerun the program.
		
		Scanner scnr = new Scanner(System.in); //creates a new Scanner
		
		SuperLotto supahLotto = new SuperLotto(); //creates a new method that can call a method outside of this method
		
		String answer; //String that attains the user's answer
		
		do { //do while statement that runs the program first
			supahLotto.initialRound();
			System.out.println("Good luck! Would you like to run the program again?");
			answer = scnr.next();
		} while ( answer.toLowerCase().contains("yes") ) ; //Loops the program if the user inputs any variation of yes
		System.out.println("Goodbye!"); //If user answer is anything that is not any variation of yes, program ends
	}

	public void initialRound() {
		
		// Runs the actual program and references the method quickPick.
		 
		
		Scanner scnr = new Scanner(System.in); //Creates a new Scanner
		
		System.out.println("");
		System.out.println("Welcome to the Quicky Mart. What is your name?"); //Asks for user name
		String name =  scnr.next();

		System.out.println("Hi " + name + ", how many Super Lotto tickets would you like?"); //Asks user how many Lotto tickets
		int numberTix = scnr.nextInt();
		System.out.println("");
		
		SuperLotto quickPicks = new SuperLotto(); //creates a method that calls a method outside of this method
		for (int i = 0; i < numberTix; i++) {
			quickPicks.quickPick(); //calls the method quickPick
		}
	}	
	public void quickPick() {
		
		// quickPick method uses an array to print the lottery numbers.
		
		
		Random rand = new Random(); //Creates a Random number generator
		int[] arrayTix = new int[5]; //Creates an array for the tickets to be hold
		int minNum = 1; 
		int maxLotto = 47;
		int maxMega = 27;
		int i;
		
		// Loop that prints the lottery ticket that ranges from 1-47.
		
		for ( i = 0; i < arrayTix.length; i++) {
			arrayTix[i] = rand.nextInt(maxLotto) + minNum; //arrayTix gets a random number from 1 to 47.
			if (arrayTix[i] == 0 ) {
				arrayTix[i] = rand.nextInt(maxLotto) + minNum; //If any array is equal to 0, get a new random number because it has to be > 0
			}	
		}
		
		// If statement that prints the first lottery number.
		
		if  (i == 0 ) {
			System.out.print(arrayTix[i] + " "); //Prints the first array number	
		}	
		
		// Loop statement that checks if previous arrays which are the random numbers and if they are repeated, they will take another new number.
		
		for ( i = 0; i < arrayTix.length; i++) { //For loop that starts the lottery ticket number
			for (int j = i + 1; j < arrayTix.length; j++) { //For loop that will help check previous numbers
				if (arrayTix[i] == arrayTix[j] ) { //If any current arrays are equal to previous array statement
					arrayTix[j] = rand.nextInt(maxLotto) - arrayTix[i]; //Gets a new number from random number generator that is not equal to the previous
					arrayTix[j] = Math.abs(arrayTix[i]); //If array value is negative, absolute value will change it to positive
				}	
			}	
		System.out.print(arrayTix[i] + " "); //Prints the array value.		
		}

		// Prints the MEGA once that can be the same as the other lottery numbers.
		
		int j = rand.nextInt(maxMega) + minNum; //Attains a random number for MEGA
		System.out.println("(MEGA: " + j + ")"); //Prints the MEGA value	
	}
}
	
