package dungeon;
import java.util.Scanner;

public class Thief extends Hero
{
    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
    }//end constructor

    public void battleChoices(DungeonCharacter opponent)
	{
    	Scanner sc = new Scanner(System.in);
		super.battleChoices(opponent);
		int choice;
		
		do
		{
			System.out.println("1. Attack Opponent"
		    		+ "\n2. Surprise Attack");
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
			    	setSpecialPower(new SurpriseAttack(opponent, this));
			    	getSpecialPower().usePower();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

		    setNumTurns(getNumTurns()-1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0);
    }
}