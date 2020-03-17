package dungeon;

public class Sniffles extends Monster
{

    public Sniffles()
	{
		super("The Sniffles", 60, 3, .7, .3, 30, 50, 30, 50);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " tries to infect " +
							opponent.getName() + " with a stuffy nose:");
		super.attack(opponent);

	}//end override of attack

}