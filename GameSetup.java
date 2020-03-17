package dungeon;
import java.util.Scanner;

public class GameSetup
{
	public Hero hero;
	public Dungeon dungeon;
	
	public GameSetup()
	{
		rules();
		hero = chooseHero();
		dungeon = new Dungeon(5);
	}

	public Hero chooseHero() {
		int choice;
		HeroFactory hf = new HeroFactory();
		Scanner kb = new Scanner(System.in);

		System.out.println("Choose a hero:\n" +
				"1. Vac Scene\n" +
				"2. Dr. Doctor\n" +
				"3. Ty Lenol\n" + 
				"4. Vicks Quill\n" +
				"5. Vitman See");
		choice = kb.nextInt();

		switch(choice)
		{
		case 1: return hf.createHero("VacScene");

		case 2: return hf.createHero("Doctor");

		case 3: return hf.createHero("TyLenol");
		
		case 4: return hf.createHero("Vicks");
		
		case 5: return hf.createHero("VitmanSee");

		default: System.out.println("invalid choice, returning Dr. Doctor");
		return hf.createHero("Doctor");
		
		}
		
	}
	
	public void rules() {
		System.out.println("Welcome to the Virus Dungeon!" + 
				"\nThe dreaded Code Smell Virus is spreading rapidly throughout the world and citizens are in a panic." +
				"\nThe only thing that can save man-kind are the Four First Aid Kits of OO. " +
				"\nUnfortunately, 5 of the worst diseases/viruses in the world have hidden them in their Dungeon." + 
				"\nThe CDC needs your help to retrieve them so the world can survive." +
				"\nNavigate your way through the maze as a daring Virus Fighter and eliminate any diseases that try and infect you." +
				"\nCollect healing potions to increase health and keep yourself ready for battle." +
				"\nFind vision potions to see into surrounding rooms and be sure to not fall into any pits the diseases have dug!" +
				"\nUse the WASD keys to move around the maze and press E to see the menu at anytime." +
				"\nGood luck, the well-being of the world is in your hands." +
				"\n");

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
