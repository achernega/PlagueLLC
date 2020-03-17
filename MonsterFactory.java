package dungeon;

public class MonsterFactory {
	
	public Monster createMonster(String choice)
	{
		Monster monster;
		if(choice.equals("Ogre"))
			monster = new Ogre();
		else if(choice.equals("Gremlin"))
			monster = new Gremlin();
		else if(choice.equals("Skeleton"))
				monster = new Skeleton();
		else
		{
			System.out.println("Invalid choice, returning Thief");
			monster = new Skeleton();
		}
		return monster;
	}
}
