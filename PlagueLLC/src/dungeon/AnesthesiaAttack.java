package dungeon;

public class AnesthesiaAttack implements Attack
{
	private DungeonCharacter opponent;
	private Hero thisChar;
	
	public AnesthesiaAttack(DungeonCharacter op, Hero dc)
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
			System.out.println("Anesthesia worked!\n" +
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
