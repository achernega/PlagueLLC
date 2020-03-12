package dungeon;

import java.util.Scanner;

public class TEMP_Tester
{
	public static void main(String[] args)
	{
		GameSetup game = new GameSetup();
		Scanner kb = new Scanner(System.in);
		do
		{
			boolean moved = false;
			while(!moved)
				moved = game.dungeon.move();
			game.hero.update(game.dungeon);
			System.out.println(game.dungeon.currentRoom());
		} while(true); //FIX this eventually
	}
}
