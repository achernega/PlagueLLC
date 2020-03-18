package dungeon;
import java.util.Random;
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
				"1. Vac Scene\n" +
				"2. Vicks Quill\n" +
				"3. Dr. Doctor\n" +
				"4. Ty Lenol\n" +
				"5. Toiler Paper Hoarder");
		choice = kb.nextInt();

		switch(choice)
		{
			case 1: System.out.println("Vac Scene has finished Phase 4 testing and has joined the battle!\n");
				return hf.createHero("VacScene");
	
			case 2: System.out.println("Vicks Quill is fresh of the shelf and ready for battle!\n");
				return hf.createHero("Vicks");
	
			case 3: System.out.println("Mr. Doctor gets a medical degree and becomes Dr. Doctor!\n");
				return hf.createHero("Doctor");
			
			case 4: System.out.println("Ty Lenol is ready to relieve pains and destroy livers!\n");
				return hf.createHero("TyLenol");
			
			case 5: System.out.println("Toiler Paper Hoarder kisses his cousin-wife goodbye and heads off to battle!\n");
				return hf.createHero("TPHoarder");
	
			default: System.out.println("Invalid choice; player gets medical degree and becomes Dr. Doctor!\n");
				return hf.createHero("Doctor");
		}
	}
	
	public Monster spawnMonster()
	{
		MonsterFactory mf = new MonsterFactory();
		int choice = (int)(Math.random() * 5) + 1;

		switch(choice)
		{
			case 1: return mf.createMonster("Covid19");
	
			case 2: return mf.createMonster("SpanishFlu");
	
			case 3: return mf.createMonster("Sniffles");
			
			case 4: return mf.createMonster("Scurvy");
			
			case 5: return mf.createMonster("BlackDeath");
	
			default:
				System.out.println("Invalid choice; returning Covid-19!");
				return mf.createMonster("Covid19");
		}
	}
	
	public void battle()
	{
		Monster monster = spawnMonster();
				
		System.out.println(hero.getName() + " battles "
				+ monster.getName()
				+ "\n---------------------------------------------");

		//do battle
		while (hero.isAlive() && monster.isAlive())
		{
			//hero goes first
			hero.battleChoices(monster);

			//monster's turn (provided it's still alive!)
			if (monster.isAlive())
				monster.attack(hero);

		}//end battle loop

		if (!monster.isAlive())
			System.out.println(hero.getName() + " was victorious!");
		else if (!hero.isAlive())
			System.out.println(hero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
	}//end battle method
	
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
					+ "5) <For Devs Only> Print Entire Dungeon\n"
					+ "0) Quit Game");
			do
			{
				choice = kb.nextInt();
				if(choice < 0 || choice > 5)
					System.out.println("Chooce valid option!");
			} while(choice < 0 || choice > 5);
			
			switch(choice)
			{
				case 1 : System.out.println(hero); break;
				
				case 2 : hero.useHealingPot(); break;
				
				case 3 : useVisionPot(); break;
				
				case 4 : break;
				
				case 5 : System.out.println(dungeon); break;
				
				case 0: hero.triggerEnd(); break;
			}
			
		} while(choice != 4);
	}
	
	public void useVisionPot()
	{
		if(hero.numVisionPots > 0)
		{
			Random r = new Random();
			System.out.println(hero.getName() + " used a vision potion!");
			hero.numVisionPots--;
			dungeon.useVisionPot();
		}
		else
			System.out.println("No vision potions left!");
	}
}
