package dungeon;

public class MonsterAttack implements Attack {
	
	private DungeonCharacter opponent;
	private Monster thisChar;
	
	public MonsterAttack(DungeonCharacter op, Monster dc)
	{
		opponent = op;
		thisChar = dc;
	}

	@Override
	public void useAttack() {
		System.out.println(thisChar.getName() + " tries to infect " + opponent.getName());
		thisChar.attack(opponent);

	}


}
