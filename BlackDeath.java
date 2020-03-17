package dungeon;

public class BlackDeath extends Monster
{

    public BlackDeath()
	{
		super("The Black Death", 250, 4, .8, .4, 30, 60, 30, 60);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " tries to infect " +
							opponent.getName() + " with extreme weakness and black fingers:");
		super.attack(opponent);

	}//end override of attack

}