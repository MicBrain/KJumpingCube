package jump61;

import static jump61.Side.*;
import static jump61.Square.square;
import java.util.Deque;
import java.util.ArrayDeque;

/** A Jump61 board state that may be modified.
 *  @author Rafayel Mkrtchyan
 */
class MutableBoard extends Board {

    /** An N x N board in initial configuration. */
    MutableBoard(int N) {
        _squareline = new Square[N * N];
        for (int index = 0; index < N * N; index++) {
            _squareline[index] = square(WHITE, 1);
        }
    }

    /** A board whose initial contents are copied from BOARD0, but whose
     *  undo histeory is clear. */
    MutableBoard(Board board0) {
        _squareline = usedCopy(board0);
    }

    @Override
    void clear(int N) {
        Square[] temp = new Square[N * N];
        for (int index = 0; index < N * N; index++) {
            temp[index] = square(WHITE, 1);
        }
        _squareline = temp;
        announce();
    }

    @Override
    void copy(Board board) {
    }

    /** Copy the contents of BOARD into me, without modifying my undo
     *  history.  Assumes BOARD and I have the same size. */
    private void internalCopy(MutableBoard board) {
    }

    /** RETURNS the copy of the BOARD. */
    private Square[] usedCopy(Board board) {
        int length = board.size() * board.size();
        Square[] currentboard = new Square[length];
        for (int index = 0; index < length; index++) {
            currentboard[index] = board.get(index);
        }
        return currentboard;
    }

    @Override
    int size() {
        Double d = new Double(Math.sqrt(_squareline.length));
        return d.intValue();
    }

    @Override
    Square get(int n) {
        return _squareline[n];
    }

    @Override
    int numOfSide(Side side) {
        int count = 0;
        for (int index = 0; index < _squareline.length; index++) {
            if (_squareline[index].getSide() == side) {
                count++;
            }
        }
        return count;
    }

    @Override
    int numPieces() {
        int count = 0;
        for (int index = 0; index < _squareline.length; index++) {
            count += _squareline[index].getSpots();
        }
        return count;
    }

    @Override
    void addSpot(Side player, int r, int c) {
        addSpot(player, sqNum(r, c));
        announce();

    }

    @Override
    void addSpot(Side player, int n) {
        if (isLegal(player, n)) {
            Square sqr = _squareline[n];
            int position = n;
            Tuple val = new Tuple(sqr, position, "INITIAL");
            moves.push(val);
            int spots = _squareline[n].getSpots();
            _squareline[n] = Square.square(player, spots + 1);
            explosion(n);
        }
        announce();
    }

    @Override
    void set(int r, int c, int num, Side player) {
        internalSet(sqNum(r, c), square(player, num));
        announce();
    }

    @Override
    void set(int n, int num, Side player) {
        internalSet(n, square(player, num));
        announce();
    }

    @Override
    void undo() {
        if (moves.peek() == null) {
            return;
        }
        Tuple mytuple = moves.pop();
        Square sqr = mytuple.getSquare();
        int position = mytuple.getposition();
        internalSet(position, sqr);
        while (!(mytuple.getmessage().equals("INITIAL"))) {
            mytuple = moves.pop();
            sqr = mytuple.getSquare();
            position = mytuple.getposition();
            internalSet(position, sqr);
        }
    }

    /** Record the beginning of a move in the undo history. */
    private void markUndo() {
    }

    /** Set the contents of the square with index IND to SQ. Update counts
     *  of numbers of squares of each color.  */
    private void internalSet(int ind, Square sq) {
        _squareline[ind] = sq;
        numWhite = numOfSide(WHITE);
        numRed = numOfSide(RED);
        numBlue = numOfSide(BLUE);
    }

    /** Notify all Observers of a change. */
    private void announce() {
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoard)) {
            return obj.equals(this);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    /** Sets a spot and color SIDE to square in positin POS. */
    private void set(Side side, int pos) {
        _squareline[pos] = Square.square(side, _squareline[pos].getSpots() + 1);
        announce();
    }

    /** Generates the main logic of the game. Creates
     *  an explosion for transefering spots to neighboring
     *  squares starting from position POS. */
    private void explosion(int pos) {
        int mypos;
        int neigpos;
        Square sqr;
        Tuple temp;
        boolean isOverfull = _squareline[pos].getSpots() > neighbors(pos);
        if (!isOverfull || winningCond()) {
            return;
        }
        Side color = _squareline[pos].getSide();
        int original = _squareline[pos].getSpots();
        int newspots = original - neighbors(pos);
        _squareline[pos] = Square.square(color, newspots);
        for (Direction dir : Direction.values()) {
            neigpos = neighborePos(pos, dir);
            if (neigpos != -1) {
                sqr = _squareline[neigpos];
                temp = new Tuple(sqr, neigpos, "RESULT");
                moves.push(temp);
                set(_squareline[pos].getSide(), neigpos);
            }
        }

        for (Direction dir : Direction.values()) {
            try {
                explosion(neighborePos(pos, dir));
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
    }

    /** Numbes of white squares. */
    private int numWhite;

    /** Numbes of red squares. */
    private int numRed;

    /** Numbes of blue squares. */
    private int numBlue;

    /** Data structure that save my moves. */
    private Deque<Tuple> moves = new ArrayDeque<Tuple>();
}
