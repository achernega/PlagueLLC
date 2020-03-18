package dungeon;
import java.util.Scanner;

public class VacScene extends Hero
{
    public VacScene()
	{
		super("Vac Scene", 125, 4, .8, 35, 60, .2);
    }//end constructor

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
			    case 1: setAttack(new HeroAttack(opponent, this));
			    		getAttack().useAttack();
			        break;
			    case 2:
			    	setAttack(new CrushingBlow(opponent, this));
			    	getAttack().useAttack();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setNumTurns(getNumTurns()-1);
			if (getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getNumTurns());

		} while(getNumTurns() > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);
    }//end battleChoices method

}//end Hero class