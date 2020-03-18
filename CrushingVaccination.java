package dungeon;

public class CrushingVaccination implements Attack
{
	private DungeonCharacter opponent;
	private Hero thisChar;
	
	public CrushingVaccination(DungeonCharacter op, Hero dc)
	{
		opponent = op;
		thisChar = dc;
	}
	
	@Override
	public void useAttack()
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(thisChar.getName() + " lands a CRUSHING VACCINATION for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(thisChar.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}
}
