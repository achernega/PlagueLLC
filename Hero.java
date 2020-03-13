package dungeon;
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;
	private SpecialPower specialPower;
	private int healingPotions;
	private int visionPotions;
	private int pillarsFound;

	//-----------------------------------------------------------------
	//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed,
			double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		readName();
	}

	public void readName()
	{
		System.out.println("Enter character name: ");
		Scanner kb = new Scanner(System.in);
		String nam = kb.nextLine();
		setName(nam);
	}//end readName method

	public void usePower()
	{
		specialPower.usePower();
	}

	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method

	public void subtractHitPoints(int hitPoints)
	{
		if (defend())
			System.out.println(getName() + " BLOCKED the attack!");
		else
			super.subtractHitPoints(hitPoints);
	}//end method

	public void battleChoices(DungeonCharacter opponent)
	{
		numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

	public int getNumTurns()
	{
		return numTurns;
	}

	public void setNumTurns(int numTurns)
	{
		this.numTurns = numTurns;
	}

	public SpecialPower getSpecialPower()
	{
		return specialPower;
	}

	public void setSpecialPower(SpecialPower specialPower)
	{
		this.specialPower = specialPower;
	}

	@Override
	public String toString() {
		return this.getName() + " has " + this.getHitPoints() + " hit points, " + healingPotions + " healing potions, " 
				+ visionPotions + " vision potions, and " + pillarsFound + " pillars found.";
	}

}//end Hero class