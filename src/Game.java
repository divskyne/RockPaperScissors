import java.util.Random;
import java.util.Scanner;

/**
Inputs: Get input from the user, their move being rock/paper/scissors

Output: Once the human move is obtained, have the computer randomly pick their move, display the output of the results.
**/

public class Game {
	
	boolean isFinished;
	int rock = 0;
	int paper = 0;
	int scissors = 0;
	String mostPlayed;
	int total = 0;
	
	public Game() {
		
	}
	public void start() {
		
		int numberOfGames = 0;
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		int pw = 0;
		int cw = 0;
		int draw = 0;
		String command = "";
		
		while(true)
		{
			if(pw > 2 || cw > 2)
			{
				System.out.println("Game Stats:");
				total = rock + paper + scissors;
				double percentageOfPWWins = ((double)pw/numberOfGames)*100;
				double percentageOfCWWins = ((double)cw/numberOfGames)*100;
				double percentageOfDraws = ((double)draw/numberOfGames)*100;
				double percentageOfCommon = ((double)mostPlayed()/total)*100;
				System.out.println("Player Wins: "+pw+" "+percentageOfPWWins+"%");
				
				System.out.println("Computer Wins: "+cw +" "+percentageOfCWWins+"%");
				System.out.println("Number of Games: "+numberOfGames);
				System.out.println("Draws: "+ draw +" "+percentageOfDraws+"%");
				
				System.out.println("most played: "+mostPlayed+", percentage:"+percentageOfCommon+" Times played: " + mostPlayed());
				break;
			}
			numberOfGames++;
			System.out.println("Enter: ");
			command = userInput.nextLine();
			keeptrack(command);
			String compMove = computerMove();
			keeptrack(compMove);
			if (command.equals(compMove)) {
				
				System.out.println("It's a Draw!");
				draw++;
			}
			if (!command.equalsIgnoreCase(compMove))
			{
				if (command.equalsIgnoreCase("Rock"))
				{
					if(compMove.equalsIgnoreCase("Paper"))
					{
						cw++;
						System.out.println("Computer Wins! " + cw +" Wins");
					}
					else
					{
						pw++;
						System.out.println("Player Wins! " + pw +" Wins");
					}
				}
					if (command.equalsIgnoreCase("Paper"))
					{
						if(compMove.equalsIgnoreCase("Scissors"))
						{
							cw++;
							System.out.println("Computer Wins! " + cw +" Wins");
						}
						else
						{
							pw++;
							System.out.println("Player Wins! " + pw +" Wins");
						}
					}
					if (command.equalsIgnoreCase("Scissors"))
					{
						if(compMove.equalsIgnoreCase("Rock"))
						{
							cw++;
							System.out.println("Computer Wins! " + cw +" Wins");
						}
						else
						{
							pw++;
							System.out.println("Player Wins! " + pw +" Wins");
						}
					}
			}
		}
	}
	
	public void keeptrack(String comp) {

		if(comp.equalsIgnoreCase("Rock"))
		{
			rock++;
		}
		if(comp.equalsIgnoreCase("Paper"))
		{
			paper++;
		}
		if(comp.equalsIgnoreCase("Scissors"))
		{
			scissors++;
		}
	}
	
	public int mostPlayed() {
		int max = Math.max(Math.max(paper, rock), scissors);
		if(max == paper)
		{
			mostPlayed = "paper";
		}
		if(max == rock)
		{
			mostPlayed = "rock";
		}
		if(max == scissors)
		{
			mostPlayed = "scissors";
		}
		return max;
	}
	
	public String computerMove() {
		int a = randomNumberGenerator();
		if ( a == 0 ) {
			return "Rock";
		}
		if ( a == 1) {
			return "Paper";
		}
		else 
		return "Scissors";
			}
	
	public int randomNumberGenerator() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(2);
	}
}
