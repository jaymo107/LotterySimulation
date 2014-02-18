import java.util.Random;
import java.util.Scanner;


public class Main {
	
	private static float totalWinnings = 0;
	private static int[] numbers = new int[6];
	private static int[] draw = new int[6];
	private static int totalMatches;
	private static int numberOfGames = 100;
	
	public static void main(String[] args){
		//draw the numbers 
		simulateGames();
		
		//print to the console
		if(totalWinnings > 0)
			System.out.println("You won £"+totalWinnings+"0");
		else
			System.out.println("You didn't win anything.");
	}
	
	private static void selectNumbers(){
		//indicate the user to enter their numbers
		System.out.println("Please enter your 6 numbers between 1 and 49:");
		
		//loop until 6 numbers have been chosen
		for(int i = 0; i < numbers.length; i++){
			Scanner s = new Scanner(System.in);
			int number = s.nextInt();
			numbers[i] = number;
		}
	}
	
	private static void draw(){
		for(int i = 0; i < draw.length; i++){
			int number = new Random().nextInt(49);
			if(number == 0){
				while(number == 0)
					number = new Random().nextInt(49);
			} draw[i] = number;
		}
	}
	
	private static int findMatches(int[] chosen, int[] draw){
		//loop through chosen numbers and see if they exist in the draw
		int matches = 0;
		
		for(int i = 0; i < chosen.length; i++){
			for(int x = 0; x < draw.length; x++){
				if(draw[x] == chosen[i]){
					matches++;
				}
			}
		} return matches;
	}
	
	private static void simulateGames(){
		//select the numbers
		selectNumbers();
		
		//loop through the games
		for(int i = 0; i < numberOfGames; i++){
			draw();
			totalMatches = findMatches(numbers, draw);
			int money = 0;
			
			switch(totalMatches){
				case 0:
					money = 0; break;
				case 1:
					money = 0; break;
				case 2:
					money = 0; break;
				case 3:
					money = 10; break;
				case 4:
					money = 50; break;
				case 5:
					money = 250; break;
				case 6:
					money = 1500000; break;
				default:
					money = 0;
			} totalWinnings += (float)money;
		}
	}
}
