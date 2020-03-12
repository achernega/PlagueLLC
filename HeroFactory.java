package dungeon;

public class HeroFactory {
	
	public Hero createHero(String choice)
	{
		Hero hero;
		if(choice.equals("Warrior"))
			hero = new Warrior();
		else if(choice.equals("Sorceress"))
			hero = new Sorceress();
		else if(choice.equals("Thief"))
			hero = new Thief();
		else
		{
			System.out.println("Invalid choice, returning Thief");
			hero = new Thief();
		}
		return hero;
	}
}
