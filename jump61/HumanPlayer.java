package jump61;

/** A Player that gets its moves from manual input.
 *  @author Rafatel Mkrtchyan
 */
class HumanPlayer extends Player {

    /** A new player initially playing COLOR taking manual input of
     *  moves from GAME's input source. */
    HumanPlayer(Game game, Side color) {
        super(game, color);
    }

    @Override
    /** Retrieve moves using getGame().getMove() until a legal one is found and
     *  make that move in getGame().  Report erroneous moves to player. */
    void makeMove() {
        int[] smalldata = new int[2];
        Side mySide = getSide();
        Game myGame = getGame();
        if (myGame.getMove(smalldata)) {
            int first = smalldata[0];
            int second = smalldata[1];
            myGame.makeMove(first, second);
        }
    }
}
