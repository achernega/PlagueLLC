package dungeon;

public class SurpriseAttack implements Attack
{
	private DungeonCharacter opponent;
	private Hero thisChar;
	
	public SurpriseAttack(DungeonCharacter op, Hero dc)
	{
		opponent = op;
		thisChar = dc;
	}
	
	@Override
	public void useAttack()
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								thisChar.getName() + " gets an additional turn.");
			thisChar.setNumTurns(thisChar.getNumTurns()+1);
			thisChar.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    thisChar.attack(opponent);
	}
}
