package dungeon;

import java.util.Scanner;

public class TEMP_Tester
{
	public static void main(String[] args)
	{
		boolean playAgain = false;
		Scanner kb = new Scanner(System.in);
		do
		{
			playGame();
			System.out.println("Play again? y/n");
			String choice = kb.nextLine();
			playAgain = choice.toLowerCase().equals("y");
		} while(playAgain);
	}
	
	private static void playGame()
	{
		GameSetup game = new GameSetup();
		Scanner kb = new Scanner(System.in);
		do
		{			
			boolean moved = false;
			while(!moved)
			{
				if(game.dungeon.menuRequest)
				{
					game.menu();
					game.dungeon.menuRequest = false;
				}
				else
					moved = game.dungeon.move();
			}
			game.hero.update(game.dungeon);
		} while(game.hero.isAlive());
	}
}
