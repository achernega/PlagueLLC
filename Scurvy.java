package dungeon;

public class Scurvy extends Monster
{

    public Scurvy()
	{
		super("Scurvy", 90, 4, .7, .3, 25, 45, 25, 45);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " tries to make " +
							opponent.getName() + "'s teeth fall out:");
		super.attack(opponent);

	}//end override of attack

}