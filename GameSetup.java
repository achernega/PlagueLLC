package dungeon;
import java.util.Scanner;

public class GameSetup
{
	public Hero hero;
	public Dungeon dungeon;
	
	public GameSetup()
	{
		hero = chooseHero();
		dungeon = new Dungeon(5);
	}

	public Hero chooseHero() {
		int choice;
		HeroFactory hf = new HeroFactory();
		Scanner kb = new Scanner(System.in);

		System.out.println("Choose a hero:\n" +
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief");
		choice = kb.nextInt();

		switch(choice)
		{
			case 1: return hf.createHero("Warrior");
	
			case 2: return hf.createHero("Sorceress");
	
			case 3: return hf.createHero("Thief");
	
			default: System.out.println("invalid choice, returning Thief");
			return hf.createHero("Thief");
		}
	}
}
