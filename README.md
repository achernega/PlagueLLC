# PokermanDungeon
Rogue-style randomly-generated dungeon crawler a la Pokemon Mystery Dungeon, except a billion times worse.

Contributions:
1. Room class design //achernega
  -> TODO<Make modular!>: Designed constructor that takes in room parameters. 
  -> Created white box method to populate rooms with necc. objects.
  -> Created toString method to represent complete room info graphically.
2. Dungeon class design //achernega
  -> Created method to generate 5x5 array of rooms.
  -> Created black box method to populate rooms with necc. objects; calls room white box classes.
  -> Designed method of movement that tracks location through dungeon.
  - > TODO: Created method to build string of entire dungeon
3. Added new fields and toString method to hero class //mtaylor pending
4. Create two new heroes and monsters //mtaylor pending
5. Game introduction and how to play //mtaylor pending
