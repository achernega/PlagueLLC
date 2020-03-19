package dungeon;

import java.util.Random;

public class Room
{
	public String doorLocations;
	public String essentials = ""; // Contains essentials like pillars, etc.
	public String nonessentials = ""; // Contains non-essentials, like items, etc.
	public String[][] roomArray;
	public boolean monster;
	
	public Room(String doorLoc)
	{
		doorLocations = doorLoc;
		
		String[][] room = new String[3][3];
		room[0][0] = "*"; room[0][2] = "*\n";
		room[2][0] = "*"; room[2][2] = "*\n";
		
		room[0][1] = doorLocations.indexOf("N") < 0 ? "*" : "-";
		room[1][2] = doorLocations.indexOf("E") < 0 ? "*\n" : "|\n";
		room[2][1] = doorLocations.indexOf("S") < 0 ? "*" : "-";
		room[1][0] = doorLocations.indexOf("W") < 0 ? "*" : "|";
		
		room[1][1] = "E";
		
		roomArray = room;
	}
	
	public void setNonEssentials()
	{
		Random r = new Random();
		String[] possibleObjects = {"H", "V", "P"};
		for(String obj : possibleObjects)
		{
			int chance = r.nextInt(10);
			if(chance == 5)
				nonessentials = nonessentials + "," + obj;
		}
	}
	
	public void setMonster()
	{
		Random r = new Random();
		int chance = r.nextInt(10);
		monster = chance == 5 || chance == 6;
	}
	
	public String toString()
	{	
		String roomToString = "";
		int j=3;
		for(int i=0; i<9; i++)
			roomToString += roomArray[i/j][i%3]; // Saved one whole line of code with this method of iteration
		
		return roomToString;
	}
}
