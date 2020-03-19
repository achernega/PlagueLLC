package dungeon;

import java.util.Scanner;

public class DungeonAdventure
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
		howToPlay();
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
					if(!game.hero.isAlive())
						game.hero.triggerEnd();
					System.out.println("Monster dropped a healing and vision potions!");
					game.hero.numHealingPots++;
					game.hero.numVisionPots++;
					System.out.println(game.dungeon.currentRoom());
				}
			}
		} while(game.hero.isAlive());
	}
	
	private static void howToPlay()
	{
		String s =
				"--------------------------------------------\n"
				+"---------- Welcome to Plague, LLC ----------\n\n"
				+"Your house's dungeon has been invaded\n"
				+"by vile diseases! You must venture down\n"
				+"and retrieve all four First Aid Kits of OO\n"
				+"in order to cleanse your dungeon of evil!\n\n"
				+"How to Play: --------------------------------\n"
				+"Use the WASD keys as direction inputs typical\n"
				+"of most PC games. Press E to acces your player\n"
				+"and item menu at any time!\n\n"
				+"Item Legend: --------------------------------\n"
				+"E | Empty Room\n"
				+"H | Healing Potion (use from E menu)\n"
				+"V | Vision Potion (use from E menu)\n"
				+"P | Deadly Pit\n"
				+"M | Multiple Items and/or a pit!\n"
				+"+ | First Aid Kit of OO\n"
				+"X | Disease! Be prepared to fight!\n\n"
				+"Begin Adenture: ------------------------------\n";
		System.out.println(s);
	}
}
