package jump61;

/** Player and square colors for jump61.
 *  @author P. N. Hilfinger
 */
enum Side {

    /** Possible square or player colors. */
    WHITE, RED, BLUE;

    /** Return the reverse of this Side: BLUE for RED, RED for BLUE, WHITE for
     *  WHITE. */
    Side opposite() {
        switch (this) {
        case BLUE:
            return RED;
        case RED:
            return BLUE;
        default:
            return WHITE;
        }
    }

    /** Return true iff it is legal for the player on my Side to play on
     *  a square belonging to SIDE. */
    boolean playableSquare(Side side) {
        return side == WHITE || side == this;
    }

    /** Return the side named SIDENAME, ignoring case differences (convenience
     *  method). */
    static Side parseSide(String sideName) {
        return valueOf(sideName.toUpperCase());
    }

    /** Return my lower-case name. */
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    /** Return my capitalized name (convenience method). */
    public String toCapitalizedString() {
        return super.toString().charAt(0) + toString().substring(1);
    }
}
