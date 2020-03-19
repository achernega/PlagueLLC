package dungeon;

public class HeroFactory {
	
	public Hero createHero(String choice)
	{
		Hero hero;
		if(choice.equals("VacScene"))
			hero = new VacScene();
		else if(choice.equals("TPHoarder"))
			hero = new TPHoarder();
		else if(choice.equals("Doctor"))
			hero = new Doctor();
		else if(choice.equals("TyLenol"))
			hero = new TyLenol();
		else if(choice.equals("Vicks"))
			hero = new Vicks();
		else
		{
			System.out.println("Invalid choice; player gets medical degree and becomes Dr. Doctor!");
			hero = new Doctor();
		}
		return hero;
	}
}