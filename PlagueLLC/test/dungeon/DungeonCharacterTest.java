package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class NullHero extends Hero{	public NullHero() {
		super(null, 2, 2, 100, 2, 2, 0);
	}
}

class hpHero extends Hero{
	public hpHero() {
		super(null, -100, -1, -1, -1, -2, 0);
	}
}


class DungeonCharacterTest {

	@Rule
    public final ExpectedException exception= ExpectedException.none();
	
	@Test
	final void testDungeonCharacter() { //tests all inputs to dungeon char
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    new hpHero();
		  });
	}

	@Test
	final void testIsAlive() {
		DungeonCharacter hp = new NullHero();
		assertEquals(true, hp.isAlive());
	}

	@Test
	final void testAttack() {
		DungeonCharacter attack = new NullHero();
		DungeonCharacter defend = new NullHero();
		attack.attack(defend);
		assertEquals(false, defend.isAlive());
	}
	
	@Test
	final void testAddHitPoints() {
		DungeonCharacter hero = new Doctor();
		hero.addHitPoints(5);
		assertEquals(new Doctor().getHitPoints()+5, hero.getHitPoints());
	}

	@Test
	final void testSubtractHitPoints() {
		DungeonCharacter nully = new NullHero();
		nully.subtractHitPoints(1);
		assertEquals(1, nully.getHitPoints());
	}
	
}
