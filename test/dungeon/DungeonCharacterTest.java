package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DungeonCharacterTest {

	@Test
	final void testAddHitPoints() {
		DungeonCharacter hero = new Doctor();
		hero.addHitPoints(5);
		assertEquals(new Doctor().getHitPoints()+5, hero.getHitPoints());
	}

	@Test
	final void testSubtractHitPoints() {
		DungeonCharacter hero1 = new Doctor();
		hero1.subtractHitPoints(hero1.getHitPoints());
		assertEquals(0, hero1.getHitPoints());
	}

}
