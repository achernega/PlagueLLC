package dungeon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dungeon
{
	private char[][] dungeon;
	public Room[][] rooms;
	private int dim; // Dimensions of room
	public int xpos, ypos; // Position of player
	boolean menuRequest = false;
	
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
			rooms[x-1][i] = new Room("N,E,W"); // Southern rooms, non-corner
		}
		rooms[0][0] = new Room("E,S"); // NW corner
		rooms[0][x-1] = new Room("W,S"); // NE corner
		rooms[x-1][x-1] = new Room("N,W"); // SE corner
		rooms[x-1][0] = new Room("N,E"); // SW corner
		
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
				
				if(takenSpots.indexOf(yrand + "," + xrand) < 0)
				{
					rooms[yrand][xrand].essentials = rooms[yrand][xrand].essentials + "," + s;
					takenSpots.add(yrand + "," + xrand);
					next = true;
					
					// This triggers when setting entrance to set initial player position
					if(s.equals("I"))
					{
						xpos = xrand;
						ypos = yrand;
					}
				}
			} while(!next);
		}
		
		// Populates rooms with non-essential objects and monsters
		for(int i=0; i<x; i++)
			for(int j=0; j<x; j++)
			{
				if(rooms[i][j].essentials.length() < 1)
				{
					rooms[i][j].setNonEssentials();
					if(rooms[i][j].nonessentials.length() < 1) // Checks after non-essentials populated
						rooms[i][j].setMonster();
				}
			}
		
		return rooms;
	}
	
	public boolean move()
	{
		Scanner kb = new Scanner(System.in);
		String possibleDir = "wasde";
		String dir;
		boolean changeXPos = false;
		
		do
		{
			System.out.print("WASD to move; E for menu:");
			dir = kb.nextLine();
			if(possibleDir.indexOf(dir) < 0)
				System.out.println("Choose valid direction!");
		} while(possibleDir.indexOf(dir) < 0);
		
		int pendingCoordChange = -1;
		
		if(possibleDir.indexOf(dir) == 0)
			pendingCoordChange = ypos - 1;
		else if(possibleDir.indexOf(dir) == 2)
			pendingCoordChange = ypos + 1;
		else if(possibleDir.indexOf(dir) == 1)
		{
			pendingCoordChange = xpos - 1;
			changeXPos = true;
		}
		else if(possibleDir.indexOf(dir) == 3)
		{
			pendingCoordChange = xpos + 1;
			changeXPos = true;
		}
		else if(possibleDir.indexOf(dir) == 4)
		{	
			menuRequest = true;
			return false;
		}
		
		if(pendingCoordChange < 0 || pendingCoordChange >= dim)
		{
			System.out.println("You hit a wall!");
			System.out.println(currentRoom());
			return false;
		}
		
		if(changeXPos)
			xpos = pendingCoordChange;
		else
			ypos = pendingCoordChange;
	
		return true;
	}
	
	public Room currentRoom()
	{
		return rooms[ypos][xpos];
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
