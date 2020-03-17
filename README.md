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
  -> TODO: Created method to build string of entire dungeon.
3. Built Hero class to interact with dungeon and rooms //achernega
  -> Created large update method that updates every parameter when hero enters new room.
4. Built gamesetup class and main method to facilitate actual gameplay //achernega
5. Added new fields and toString method to hero class //mtaylor pending
6. Create two new heroes and monsters //mtaylor pending
7. Game introduction and how to play //mtaylor pending
