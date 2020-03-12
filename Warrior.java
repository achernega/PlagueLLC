package dungeon;
import java.util.Scanner;

public class Warrior extends Hero
{
    public Warrior()
	{
		super("Warrior", 125, 4, .8, 35, 60, .2);
    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method
	
    public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner sc = new Scanner(System.in);
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent"
		    		+ "\n2. Crushing Blow on Opponent");
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
			    	setSpecialPower(new CrushingBlow(opponent, this));
			    	getSpecialPower().usePower();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns()-1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);
    }//end battleChoices method

}//end Hero class