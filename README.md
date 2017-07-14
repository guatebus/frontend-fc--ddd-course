# Iterative development of a simple cli game using ddd

## User story 1
```
*** As A User, I want to create a player:
**** A Player will have:
***** Name
***** Hit Points: 10
***** Attack Points: 2
***** Defense Points: 2
***** Level: 1
***** Experience: 0
***** Gold: 0
```

## User story 2
```
*** As a User I want to move around the map with my player:
**** You can't cross map boundaries
**** Boundaries will be marked with a '#'
**** The player will be marked with a '@'
**** Player can only move up, down, left and right
**** Map must be square shaped of 8x8 tiles
```

## User story 3
```
*** As a User I want to open a treasure with my player:
**** The treasure will be marked with a '$'
**** A treasure can't be outside the map
**** Treasures can only be opened once.
**** When open, it will be marked with a '#'.
**** A treasure will add to the player a pre-defined amount of gold
**** The treasure will have 250G and it will be positioned at 4,6
```

## User story 4
```
* As a User I want to be able to open more than one treasure
** The new gold treasure will be at 2,3 
** The new gold treasure will contain 500G
```

## User story 5
```
* As a User, I want to be able to open an experience treasure
** The treasure will be at 1,1
** The treasure will contain 500 EXP
```

## User story 6
```
* As a User, I want my player to level up.
** Level formulae is: abs((50/3) * (x^3 - 6x^2 + 17x - 12)) where X is the current level.
*** Leveling up to level 2 needs 500 EXP
*** Leveling up to level 3 needs 1900 EXP
** Player Attack Points are: 2 + floor(level / 3)
** Player Defense Points are: 2 + floor(level / 2)
** Player Hit Points are: 10 + ((level - 1) * 2)
```

## User story 7
```
* As a User, I want to open a treasure
** The user rolls a dice (from 0 to 100)
*** Runs automagically (implement it with SecureRandom)
** If the dice is 80+ (inclusive):
*** then the user grabs the treasure and can open again the treasure
** If the dice es 10- 
*** the treasure chest is empty (bad luck)
** otherwise we use the normal behaviour
```

## User story 8
```
* As a User I want to buy an item in the shop
** We will mark the shop as a S in the map
** The shop will be at 5x7
** When the player collides with the shop, it will show an option B)uy Items
```

## User story 9
```
* As a User I want to see a list with the items in the shop
** The item list will have the following format:
*** $IDX) $NAME - +$MODIFIER atk. - ${PRICE}G
** The list shown will contain the following items:
*** Short Sword, +1 atk, 100G
*** Sabre, +3 atk, 500G
*** Long Sword, +6 atk, 1200G
*** Katana, +5 atk, 1000G
*** Master Sword, +10 atk, 1800G```
```

## User story 10
```
* As a User I want to buy an item from the shop with my player.
** I can only buy an item if the player has the necessary gold for the transaction
** After buying the object, pays the price in gold.
** The player adds the modifier of the weapon to it's stats.
*** A player that buys the Katana, pays 1000G and wins 5 atk points.
** After buying, the bought item should be marked in the shop list with an *.
```