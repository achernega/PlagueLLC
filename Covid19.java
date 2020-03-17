package dungeon;

public class Covid19 extends Monster
{

    public Covid19()
	{
		super("Covid-19", 150, 5, .8, .4, 15, 30, 20, 40);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " tries to infect " +
							opponent.getName() + " with a sore throat and cough:");
		super.attack(opponent);

	}//end override of attack

}//end class Gremlin