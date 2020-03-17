package dungeon;

public class Battle
{
	Hero hero;
	Monster monster;
	
	public void battle(Monster mon)
	{
		char pause = 'p';
		System.out.println(hero.getName() + " battles "
				+ monster.getName()
				+ "\n---------------------------------------------");

		//do battle
		while (hero.isAlive() && monster.isAlive() && pause != 'q')
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
}
