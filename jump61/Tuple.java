package jump61;
import static jump61.Side.*;

/** An implementation of tuple data structure.
 *  @author Rafatel Mkrtchyan
 */

public class Tuple {

    /** First value. */
    private Square _sqr;
    /** Second value. */
    private int _position;
    /** Third value. */
    private String _message;

    /** Constructore that stors SQR, POSITION and MESSAGE. */
    public Tuple(Square sqr, int position, String message) {
        _sqr = sqr;
        _position = position;
        _message = message;
    }

    /** RETURNS square. */
    public Square getSquare() {
        return this._sqr;
    }

    /** Sets the value of square to S. */
    public void setSquare(Square s) {
        this._sqr = s;
    }

    /** RETURNS position. */
    public int getposition() {
        return this._position;
    }

    /** Sets the value of position to NUM. */
    public void setposition(int num) {
        this._position = num;
    }

    /** RETURNS message. */
    public String getmessage() {
        return this._message;
    }

    /** Sets the value of message to MESS. */
    public void setmessage(String mess) {
        this._message = mess;
    }
}
