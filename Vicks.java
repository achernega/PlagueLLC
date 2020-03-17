package dungeon;
import java.util.Scanner;

public class Vicks extends Hero
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

    public Vicks()
	{
		super("Vicks Quill", 70, 3, .6, 20, 40, .3);
    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " throws a punch at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

    public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner sc = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent"
		    		+ "\n2. Increase Hit Points");
		    System.out.print("Choose an option: ");
		    
		    try
		    {
		    	choice = sc.nextInt();
		    }
		    catch(Exception e)
		    {
		    	choice = 1;
		    	System.out.println("Invalid choice; performing regular attack!");
		    }

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2:
			    	setSpecialPower(new IncreaseHP(MAX_ADD, MIN_ADD, this));
			    	getSpecialPower().usePower();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

		    setNumTurns(getNumTurns()-1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class