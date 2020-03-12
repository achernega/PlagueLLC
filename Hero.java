package dungeon;

import java.util.Random;
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns, numHealingPots = 0, numVisionPots = 0, numPillars = 0;
	private SpecialPower specialPower;

	public Hero(String name, int hitPoints, int attackSpeed,
			double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		readName();
	}

	public void update(Dungeon dungeon)
	{
		Room room = dungeon.currentRoom();
		
		String ess = room.essentials;
		String ness = room.nonessentials;
		
		if(ess.length() > 0)
		{
			String[] essArr = ess.split(",");
			{
				for(String s : essArr)
				{
					if(s.equals("P1") || s.equals("P2") || s.equals("P3") || s.equals("P4"))
					{
						System.out.println(getName() + " found a Pillar of OO!");
						numPillars++;
						room.essentials = "";
						room.roomArray[1][1] = "A";
					}
				}
			}
		}
		else if(ness.length() > 0)
		{
			boolean pitExists = false;
			String[] nessArr = ness.split(",");
			if(nessArr.length > 2)
				room.roomArray[1][1] = "M";
			
			for(String s : nessArr)
			{
				if(s.equals("H"))
				{
					System.out.println(getName() + " found a healing potion!");
					numHealingPots++;
				}
				if(s.equals("V"))
				{
					System.out.println(getName() + " found a vision potion!");
					numVisionPots++;
				}
				if(s.equals("P"))
				{
					System.out.println(getName() + " fell into a pit!");
					Random r = new Random();
					subtractHitPoints(r.nextInt(20));
					pitExists = true;
				}
			}
			room.nonessentials = pitExists ? "P" : "";
		}
		else if(room.monster)
		{
			// battle(); // FIX !!!!!!!!!!
		}
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

}//end Hero class