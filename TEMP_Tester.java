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
		System.out.println(game.dungeon.currentRoom());
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
					System.out.println(game.dungeon.currentRoom());
				}
				else
					moved = game.dungeon.move();
			}
			game.hero.update(game.dungeon);
			if(game.dungeon.currentRoom().monster)
			{
				System.out.println("You have encountered a disease!\nWant to battle? y/n");
				String fleeChoice = kb.nextLine();
				if(fleeChoice.toLowerCase().equals("n"))
				{
					System.out.println(game.hero.getName() + " fleed the battle!");
					System.out.println(game.dungeon.currentRoom());
				}
				else
				{
					game.battle();
					game.hero.setNumTurns(2);
					game.dungeon.currentRoom().monster = false;
					System.out.println("Monster dropped a healing and vision potions!");
					game.hero.numHealingPots++;
					game.hero.numVisionPots++;
					System.out.println(game.dungeon.currentRoom());
				}
			}
		} while(game.hero.isAlive());
	}
}
