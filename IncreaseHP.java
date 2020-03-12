package dungeon;

public class IncreaseHP implements SpecialPower
{
	private int MAX_ADD, MIN_ADD;
	private Hero thisChar;
	
	public IncreaseHP(int max, int min, Hero dc)
	{
		MAX_ADD = max;
		MIN_ADD = min;
		thisChar = dc;
	}
	
	@Override
	public void usePower()
	{
		int hPoints;
		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		thisChar.addHitPoints(hPoints);
		System.out.println(thisChar.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ thisChar.getHitPoints()
							+ "\n");
	}
}
