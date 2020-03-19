package dungeon;

public class MonsterFactory {
	
	public Monster createMonster(String choice)
	{
		Monster monster;
		if(choice.equals("SpanishFlu"))
			monster = new SpanishFlu();
		else if(choice.equals("Covid19"))
			monster = new Covid19();
		else if(choice.equals("Sniffles"))
				monster = new Sniffles();
		else if(choice.equals("Scurvy"))
			monster = new Scurvy();
		else if(choice.equals("BlackDeath"))
			monster = new BlackDeath();
		else
		{
			System.out.println("Invalid choice; Covid-19 enters the battle!");
			monster = new Covid19();
		}
		return monster;
	}
}
