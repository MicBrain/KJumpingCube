package jump61;

import static jump61.Side.*;

/** Represents the contents of one square on a Jump61 game.
 *  @author P. N. Hilfinger
 */
class Square {

    /** A new Square occupied by SIDE and containing SPOTS spots. This is
     *  private, since clients will use .square to avoid creation of
     *  redundant objects. */
    private Square(Side side, int spots) {
        _side = side;
        _spots = spots;
    }

    /** Return a (unique) Square controlled by SIDE with SPOTS spots on it.
     *  We memoize the creation of Squares to save time, since they are
     *  immutable objects.  As a special case, when SPOTS is 0 or SIDE
     *  is WHITE, returns the value of INITIAL. */
    static Square square(Side side, int spots) {
        if (spots == 0 || side == WHITE) {
            return INITIAL;
        }
        if (_allSquares[side.ordinal()][spots] == null) {
            _allSquares[side.ordinal()][spots] = new Square(side, spots);
        }
        return _allSquares[side.ordinal()][spots];
    }

    /** Return the Side controlling this Square. */
    Side getSide() {
        return _side;
    }

    /** Sets the side of square to SIDE. */
    public void setSide(Side side) {
        this._side = side;
    }

    /** Return the number of spots for this Square. */
    int getSpots() {
        return _spots;
    }

    /** Sets the number of spots to SPOTS. */
    public void setSpots(int spots) {
        this._spots = spots;
    }

    /** Adds spots of my square. */
    public void addSpot() {
        _spots += 1;
    }

    /* Because there is only one Square with any particular contents, it is not
     * necessary to override .equals and .hashCode; the default implementations
     * work. */

    /** Memo table for Squares, allowing spot values up to 9
     *  (probably excessive). */
    private static Square[][] _allSquares = new Square[3][10];

    /** A Square on the initial board. */
    static final Square INITIAL = new Square(Side.WHITE, 1);

    /** The Side occupying this Square. */
    private Side _side;

    /** The number of spots in this Square. */
    private int _spots;
}
