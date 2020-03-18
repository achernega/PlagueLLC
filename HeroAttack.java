package dungeon;

public class HeroAttack implements Attack {
	
	private DungeonCharacter opponent;
	private Hero thisChar;
	
	public HeroAttack(DungeonCharacter op, Hero dc)
	{
		opponent = op;
		thisChar = dc;
	}

	@Override
	public void useAttack() {
		System.out.println(thisChar.getName() + " throws a punch at " + opponent.getName());
		thisChar.attack(opponent);

	}

}
