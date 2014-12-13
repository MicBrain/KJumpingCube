package jump61;

import static jump61.Side.*;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

/** Unit tests of Boards.
 *  @author Rafayel Mkrtchyan
 */

public class AItest {

    /** Sample test for getting free squares. */
    @Test
    public void testPossibleMoves() {
        int N = 3;
        MutableBoard board = new MutableBoard(N);
        ArrayList<Integer> indeces;
        board.set(0, 1, RED);
        board.set(1, 1, BLUE);
        board.set(2, 1, RED);
        board.set(3, 4, RED);
        board.set(3, 1, WHITE);
        board.set(0, 1, RED);
        board.set(1, 1, BLUE);
        board.set(2, 1, RED);
        board.set(3, 1, RED);
        board.set(0, 1, BLUE);
        board.set(1, 1, WHITE);
        board.set(2, 1, RED);
        board.set(3, 1, RED);
    }

    /** Run the unit tests in this file. ARGS. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(AItest.class));
    }
}
