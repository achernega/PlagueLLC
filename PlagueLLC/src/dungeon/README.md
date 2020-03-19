# PlagueLLC
Rogue-style randomly-generated dungeon crawler with a viral twist.

Contributions:
1. Room class design //achernega
  -> Designed constructor that takes in room parameters. 
  -> Created white box method to populate rooms with necc. objects.
  -> Created toString method to represent complete room info graphically.
2. Dungeon class design //achernega
  -> Created method to generate 5x5 array of rooms.
  -> Created black box method to populate rooms with necc. objects; calls room white box classes.
  -> Designed method of movement that tracks location through dungeon.
  -> Created method to build string of entire dungeon.
  -> Added full vision potion functionality.
3. Built Hero class to interact with dungeon and rooms //achernega
  -> Created large update method that updates every parameter when hero enters new room.
  -> Healing potion functionality added.
4. Built gamesetup class and main method to facilitate actual gameplay //achernega
  -> In-game player menu added with full funtionality.
5. Build DungeonAdventure class playGame() method //achernega
6. Added characters: Dr. Doctor, Vac Scene, TPHoarder, Scurvy //achernega
7. Added characters: Vicks Quill, Ty Lenol, Sniffles //mtaylor
8. Added characters: Black Death, Spanish Flu, Covid19 //jbrown
9. Added new fields and toString method to hero class //mtaylor pending
10. Game introduction and how to play //mtaylor pending
11. Strategy pattern for Special Attacks //achernega
12. Strategy pattern for regular attacks //mtaylor
