package dungeon;

public class CrushingBlow implements SpecialPower
{
	private DungeonCharacter opponent;
	private Hero thisChar;
	
	public CrushingBlow(DungeonCharacter op, Hero dc)
	{
		opponent = op;
		thisChar = dc;
	}
	
	@Override
	public void usePower()
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(thisChar.getName() + " lands a CRUSHING BLOW for " + blowPoints
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
