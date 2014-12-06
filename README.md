KJumpingCube
============

### Game Description
   KJumpingCube is a simple dice driven tactical game. It is a pure strategy game, involving no element of chance. The playing area consists of squares containing points. Players move by clicking on either a vacant square, or on own square. This version of KJumpingCube allows a user to play against another user or against a computer, or allows computer to play itself.

   The playing area is a box of cubes containing points. When the game starts each cube has one point, no owner and a neutral color. If you click on a neutral cube it becomes yours, changes to your color and increases by one point. Your objective is to capture all the cubes, but now it is your opponent's turn. Players move and add points by clicking on neutral cubes or their own cubes. The only way to capture your opponent's cubes is to increase a cube's value until it reaches a maximum and expands into neighboring cubes. Then those cubes become yours, even if they belonged to your opponent before. Sometimes a neighbor will also reach a maximum value and expand and a cascade of moves will spread across the board. Large numbers of cubes can suddenly change hands and this is where KJumpingCube becomes interesting and challenging.

### Rules

Here are all the rules of this game:

1. A move consists of clicking on a cube that does not belong to your opponent.
2. The move increases the points in the cube by one.
3. At the start of the game, each cube has one point, is painted in a neutral color and has no owner.
4. Each player has a color to mark the ownership of cubes.
5. By clicking a cube that has no owner, the player becomes the owner of that cube and it changes its color to the player's color. Simultaneously the cube’s value is increased by one.
6. If a cube has more points than it has neighbors, one point jumps to each of the neighbors.
7. During such a move, all the neighboring cubes become owned by the player who moved and so do all of their points, even if the neighbors were neutral or owned by the other player.
8. Neighbors are the cubes located above, below, at left or at right, but not diagonally. Corner cubes have two neighbors, edge cubes have three and center cubes have four.
9. If a move leaves a neighbor with a maximum number of points, the move continues automatically to the neighbor's neighbors and so on, in a cascade. A large number of cubes can change ownership during such a move.
10. The winner is the player who ends up owning all the cubes.
11. You can use settings to select board size, computer players and players' colors. You can also pit one computer player against another and watch the outcome.

### References
1. https://docs.kde.org/stable/en/kdegames/kjumpingcube/rules_and_tips.html
