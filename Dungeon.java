package dungeon;

import java.util.ArrayList;
import java.util.Random;

public class Dungeon
{
	private char[][] dungeon;
	private Room[][] rooms;
	private int dim; // Dimensions of room
	
	public Dungeon(int x)
	{
		dim = x;
		dungeon = buildDungeonGUI(); // Parameters are dimensions of dungeon
		rooms = buildRoomMatrix();
	}
	
	private char[][] buildDungeonGUI()
	{
		int x = 2*dim + 1;
		char[][] charD = new char[x][x];
		
		// Boundaries of dungeon
		for(int i=0; i<x; i++)
		{
			charD[0][i] = '*';
			charD[x-1][i] = '*';
			if(i<x)
			{
				charD[i][0] = '*';
				charD[i][x-1] = '*';
			}
		}
		
		// Vertical/Horizontal doors; inner wall corners
		for(int i=1; i<x-1; i+=2)
			for(int j=2; j<x-1; j+=2)
			{
				charD[i][j] = '|';
				charD[j][i] = '-';
				charD[j][i+1] = '*';
			}
		
		return charD;
	}
	
	private Room[][] buildRoomMatrix()
	{
		int x = dim;
		Random r = new Random();
		
		// Following code creates empty rooms with door locations designated
		Room[][] rooms = new Room[x][x];
		for(int i=1; i<x-1; i++)
		{
			rooms[i][0] = new Room("N,E,S"); // Western rooms, non-corner
			rooms[i][x-1] = new Room("N,S,W"); // Eastern rooms, non-corner
			rooms[0][i] = new Room("E,S,W"); // Northern rooms, non-corner
			rooms[x-1][i] = new Room("N,E,W"); // Sourthern rooms, non-corner
		}
		rooms[0][0] = new Room("E,S"); // NW corner
		rooms[0][x-1] = new Room("W,S"); // NE corner
		rooms[x-1][x-1] = new Room("N,W"); // SE corner
		rooms[x-1][0] = new Room("N,W"); // SW corner
		
		for(int i=1; i<x-1; i++)
			for(int j=1; j<x-1; j++)
				rooms[i][j] = new Room("N,E,S,W");
		
		// Following code populates rooms with essential objects
		String[] essentialObjects = {"I", "O", "P1", "P2", "P3", "P4"};
		ArrayList<String> takenSpots = new ArrayList<String>();
		
		boolean next = false;
		for(String s : essentialObjects)
		{
			do
			{
				next = false;
				int xrand = r.nextInt(x);
				int yrand = r.nextInt(x);
				System.out.println(xrand + " " + yrand);
				if(takenSpots.indexOf(xrand + "," + yrand) < 0)
				{
					rooms[xrand][yrand].params = rooms[xrand][yrand].params + "," + s;
					next = true;
				}
			} while(!next);
		}
		
		return rooms;
	}
	
	public String toString()
	{
		String s = "";
		for(int i=0; i<(dim*2 + 1); i++) {
			for(int j=0; j<(dim*2 + 1); j++)
				s += dungeon[i][j];
			s += "\n";
		}
		return s;
	}
}
