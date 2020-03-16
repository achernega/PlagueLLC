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
			boolean foundPillar = false, foundExit = false;
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
						foundPillar = true;
					}
					else if(s.equals("I"))
					{
						System.out.println("Found entrance, no monsters can get to you here.");
						room.roomArray[1][1] = "I";
					}
					else if(s.equals("O"))
					{
						room.roomArray[1][1] = "O";
						foundExit = true;
						System.out.println(dungeon.currentRoom());
						System.out.println(getName() + " found exit, want to quit?");
						triggerEnd();
					}
				}
			}
			if(!foundExit)
				System.out.println(dungeon.currentRoom());
			if(foundPillar)
				room.roomArray[1][1] = "E";
		}
		else if(ness.length() > 0)
		{
			boolean pitExists = false;
			String[] nessArr = ness.split(",");
			boolean multipleItems = nessArr.length > 2;
			
			for(String s : nessArr)
			{
				if(s.equals("H"))
				{
					System.out.println(getName() + " found a healing potion!");
					if(!multipleItems)
						room.roomArray[1][1] = "H";
					numHealingPots++;
				}
				if(s.equals("V"))
				{
					System.out.println(getName() + " found a vision potion!");
					if(!multipleItems)
						room.roomArray[1][1] = "V";
					numVisionPots++;
				}
				if(s.equals("P"))
				{
					System.out.println(getName() + " fell into a pit!");
					Random r = new Random();
					subtractHitPoints(r.nextInt(40));
					pitExists = true;
					if(!multipleItems)
						room.roomArray[1][1] = "P";
				}
			}
			if(multipleItems)
				room.roomArray[1][1] = "M";
			
			System.out.println(dungeon.currentRoom());
			
			room.nonessentials = pitExists ? "P" : "";
			room.roomArray[1][1] = pitExists ? "P" : "E";
		}
		else if(room.monster)
		{
			room.roomArray[1][1] = "X";
			System.out.println(dungeon.currentRoom());
			// battle(); // FIX !!!!!!!!!!
			room.monster = false;
			room.roomArray[1][1] = "E";
		}
		else
			System.out.println(dungeon.currentRoom());
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
	
	public void triggerEnd()
	{
		// FIX: add end code!
	}

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