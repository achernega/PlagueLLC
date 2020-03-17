package dungeon;

public class SpanishFlu extends Monster
{

    public SpanishFlu()
	{
		super("Spanish Flu", 100, 2, .6, .1, 30, 50, 30, 50);

    }//end constructor
    
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " tries to infect " +
							opponent.getName() + " with a fever and body aches:");
		super.attack(opponent);

	}//end override of attack
}//end Monster class