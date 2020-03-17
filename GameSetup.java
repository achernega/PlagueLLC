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
	
	public void menu()
	{
		Scanner kb = new Scanner(System.in);
		int choice = 0;
		do
		{
			System.out.println("--- Player Menu ---\n"
					+ "Choose option:\n"
					+ "1) See All Stats\n"
					+ "2) Use Healing Potion\n"
					+ "3) Use Vision Potion\n"
					+ "4) Exit Menu\n"
					+ "0) Quit Game");
			do
			{
				choice = kb.nextInt();
				if(choice < 0 || choice > 4)
					System.out.println("Chooce valid option!");
			} while(choice < 0 || choice > 4);
			
			switch(choice)
			{
				case 1 : System.out.println(hero); break;
				
				case 2 : hero.useHealingPot(); break;
				
				case 3 : hero.useVisionPot(); break;
				
				case 4 : break;
				
				case 0: hero.triggerEnd(); break;
			}
			
		} while(choice != 4);
	}
}
