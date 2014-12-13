package jump61;
import java.util.ArrayList;

/** An automated Player.
 *  @author Rafayel Mkrtchyan.
 */

class AI extends Player {

    /** Time allotted to all but final search depth (milliseconds). */
    private static final long TIME_LIMIT = 15000;

    /** Number of calls to minmax between checks of elapsed time. */
    private static final long TIME_CHECK_INTERVAL = 10000;

    /** Number of milliseconds in one second. */
    private static final double MILLIS = 1000.0;

    /** A new player of GAME initially playing COLOR that chooses
     *  moves automatically.
     */
    public AI(Game game, Side color) {
        super(game, color);
    }

    /** A sample class that contains information about each move. */
    class Move {

        /** Variable describing move. */
        private int _move;
        /** Variable describing its value. */
        private int _value;

        /** Constructor for Move class with MOVE and VALUE. */
        Move(int move, int value) {
            _move = move;
            _value = value;
        }

        /** RETURNS the value of move. */
        int getMove() {
            return _move;
        }

        /** Set the _move to be MOVE. */
        void setMove(int move) {
            _move = move;
        }

        /** RETURNS the value of value of move. */
        int getValue() {
            return _value;
        }

        /** Set the value of move to be VALUE. */
        void setValue(int value) {
            _value = value;
        }
    }

    @Override
    void makeMove() {
        ArrayList<Integer> possibilities;
        MutableBoard theBoard;
        int maxBig = Integer.MAX_VALUE;
        Game currentgame = getGame();
        theBoard = new MutableBoard(currentgame.getmyboard());
        possibilities = possibleMoves(getSide(), theBoard);
        Move finalMove = minimax(getSide(), theBoard, 4, maxBig, possibilities);
        int moveposs = finalMove.getValue();
        currentgame.makeMove(moveposs);
        currentgame.reportMove(getSide(), moveposs);
    }

     /** Returns all possible moves of a board B for player P. */
    public ArrayList<Integer> possibleMoves(Side p, Board b) {
        ArrayList<Integer> indeces = new ArrayList<Integer>();
        int length = b.size() * b.size();
        for (int index = 0; index < length; index++) {
            if (b.isLegal(p, index)) {
                indeces.add(index);
            }
        }
        return indeces;
    }

    /** @RETURN Minimax startegy, P, B, CUTOFF, DEPTH, MOVES .*/
    Move minimax(Side p, Board b, int depth, int cutoff,
                ArrayList<Integer> moves) {
        if (depth == 0) {
            return guessBestMove(p, b, moves);
        }
        int newValue;
        int currentBest = -1 * Integer.MAX_VALUE;
        int bestMove = -1;
        ArrayList<Integer> possibles;
        Side opponent;
        for (int move : moves) {
            b.addSpot(p, move);
            MutableBoard currentBoard = new MutableBoard(b);
            b.undo();
            opponent = p.opposite();
            int initial = -1 * currentBest;
            possibles = possibleMoves(p.opposite(), currentBoard);
            Move comeback = minimax(opponent, currentBoard,
                depth - 1, initial, possibles);
            if (-1 * comeback.getMove() >= currentBest) {
                newValue = -1 * comeback.getMove();
                currentBest = newValue;
                bestMove = move;
                if (newValue >= cutoff) {
                    break;
                }
            }
        }
        return new Move(currentBest, bestMove);
    }

    /** @RETURN Base Case of Recursion. P, B, MOVES, CUTOFF */
    private Move guessBestMove(Side p, Board b, ArrayList<Integer> moves) {
        Side whoWon = b.getWinner();
        if (whoWon == p) {
            Move mymove = new Move(Integer.MAX_VALUE, -1);
            return mymove;
        }
        if (whoWon == p.opposite()) {
            Move mymove = new Move(-1 * Integer.MAX_VALUE, -1);
            return mymove;
        }
        int best = -1;
        int currentBest = -1 * Integer.MAX_VALUE;
        int currentValue;
        for (int move : moves) {
            b.addSpot(p, move);
            currentValue = staticEval(p, b);
            if (currentBest < currentValue) {
                currentBest = currentValue;
                best = move;
            }
            b.undo();
        }
        Move finalmove = new Move(currentBest, best);
        return finalmove;
    }

    /** Returns heuristic value of board B for player P.
     *  Higher is better for P. */
    private int staticEval(Side p, Board b) {
        int firstOpponent = 0;
        int secondOpponent = 0;
        int length = b.size();
        length = length * length;
        for (int index = 0; index < length; index++) {
            Side curr = b.get(index).getSide();
            if (curr == p) {
                firstOpponent++;
            }
            if (curr == p.opposite()) {
                secondOpponent++;
            }
        }
        if (firstOpponent == length) {
            return Integer.MAX_VALUE;
        }
        if (secondOpponent == length) {
            return -Integer.MAX_VALUE;
        }
        return firstOpponent - secondOpponent;
    }
}
