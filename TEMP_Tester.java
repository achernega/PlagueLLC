package dungeon;

public class TEMP_Tester
{
	public static void main(String[] args)
	{
		Dungeon d = new Dungeon(5);
		//Room r= new Room("N,E,S,W");
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++)
				System.out.println((i+j) + ") " + d.rooms[i][j].essentials + " | " + d.rooms[i][j].nonessentials + " | " + d.rooms[i][j].monster);
	}
}
