package jump61;

import static jump61.Side.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** Unit tests of Boards.
 *  @author Rafayel Mkrtchyan
 */
public class BoardTest {

    private static final String NL = System.getProperty("line.separator");

    @Test
    public void testConstructor() {
        int N = 5;
        MutableBoard board = new MutableBoard(N);
        assertEquals(5, board.size());
        int length = N * N;
        for (int index = 0; index < length; index++) {
            Square current = board.get(index);
            assertEquals(WHITE, current.getSide());
            assertEquals(1, current.getSpots());
        }
    }

    @Test
    public void testClear() {
        int N = 4;
        int L = 8;
        MutableBoard board = new MutableBoard(N);
        board.set(0, 2, RED);
        board.set(1, 3, BLUE);
        board.set(2, 3, RED);
        board.set(3, 4, RED);
        board.set(4, 1, BLUE);
        int length = N * N;
        assertEquals(4, board.size());
        board.clear(L);
        assertEquals(8, board.size());
        for (int index = 0; index < length; index++) {
            Square current = board.get(index);
            assertEquals(WHITE, current.getSide());
            assertEquals(1, current.getSpots());
        }
    }

    @Test
    public void testsizenew() {
        MutableBoard a = new MutableBoard(2);
        MutableBoard b = new MutableBoard(3);
        MutableBoard c = new MutableBoard(4);
        MutableBoard d = new MutableBoard(5);
        MutableBoard e = new MutableBoard(6);
        MutableBoard f = new MutableBoard(7);
        MutableBoard g = new MutableBoard(8);
        MutableBoard h = new MutableBoard(9);
        MutableBoard k = new MutableBoard(10);
        assertEquals(2, a.size());
        assertEquals(3, b.size());
        assertEquals(4, c.size());
        assertEquals(5, d.size());
        assertEquals(6, e.size());
        assertEquals(7, f.size());
        assertEquals(8, g.size());
        assertEquals(9, h.size());
        assertEquals(10, k.size());
    }

    @Test
    public void testspots() {
        int N = 2;
        MutableBoard board = new MutableBoard(N);
        board.set(0, 2, RED);
        board.set(1, 3, BLUE);
        board.set(2, 3, RED);
        board.set(3, 4, BLUE);
        assertEquals(RED, board.get(0).getSide());
        assertEquals(2, board.get(0).getSpots());
        assertEquals(BLUE, board.get(1).getSide());
        assertEquals(3, board.get(1).getSpots());
        assertEquals(RED, board.get(2).getSide());
        assertEquals(3, board.get(2).getSpots());
        assertEquals(BLUE, board.get(3).getSide());
        assertEquals(4, board.get(3).getSpots());
    }

    @Test
    public void testgetspot() {
        MutableBoard l = new MutableBoard(7);
        l.set(3, 3, BLUE);
        assertEquals(3, l.get(3).getSpots());
        assertEquals(BLUE, l.get(3).getSide());
    }

    @Test
    public void testnumofSide() {
        int N = 5;
        MutableBoard board = new MutableBoard(N);
        assertEquals(25, board.numOfSide(WHITE));
        board.set(0, 2, RED);
        board.set(1, 3, BLUE);
        board.set(2, 3, RED);
        board.set(3, 4, BLUE);
        assertEquals(2, board.numOfSide(RED));
        assertEquals(2, board.numOfSide(BLUE));
    }

    @Test
    public void testnumPieces() {
        int N = 4;
        MutableBoard board = new MutableBoard(N);
        assertEquals(16, board.numPieces());
        board.set(0, 2, RED);
        board.set(1, 2, BLUE);
        board.set(2, 2, RED);
        board.set(3, 2, BLUE);
        assertEquals(20, board.numPieces());
    }

    @Test
    public void testaddSpot() {
        int N = 3;
        MutableBoard board = new MutableBoard(N);
        board.addSpot(RED, 1, 2);
        assertEquals(RED, board.get(1, 2).getSide());
        assertEquals(2, board.get(1, 2).getSpots());
        board.addSpot(BLUE, 1, 3);
        assertEquals(BLUE, board.get(1, 3).getSide());
        assertEquals(2, board.get(1, 3).getSpots());
    }

    @Test
    public void testwinningCond() {
        int N = 2;
        MutableBoard board = new MutableBoard(N);
        assertFalse(board.winningCond());
        board.set(0, 2, RED);
        board.set(1, 2, BLUE);
        board.set(2, 2, RED);
        board.set(3, 2, BLUE);
        assertFalse(board.winningCond());
        board.set(0, 2, BLUE);
        board.set(1, 2, BLUE);
        board.set(2, 2, BLUE);
        board.set(3, 2, BLUE);
        assertTrue(board.winningCond());
        board.set(1, 2, RED);
        assertFalse(board.winningCond());
    }

    @Test
    public void testSize() {
        Board B = new MutableBoard(5);
        assertEquals("bad length", 5, B.size());
        ConstantBoard C = new ConstantBoard(B);
        assertEquals("bad length", 5, C.size());
        Board D = new MutableBoard(C);
        assertEquals("bad length", 5, C.size());
    }

    @Test
    public void testSet() {
        Board B = new MutableBoard(5);
        B.set(2, 2, 1, RED);
        assertEquals("wrong number of spots", 1, B.get(2, 2).getSpots());
        assertEquals("wrong color", RED, B.get(2, 2).getSide());
        assertEquals("wrong count", 1, B.numOfSide(RED));
        assertEquals("wrong count", 0, B.numOfSide(BLUE));
        assertEquals("wrong count", 24, B.numOfSide(WHITE));
    }

    @Test
    public void testMove() {
        Board B = new MutableBoard(6);
        checkBoard("#0", B);
        B.addSpot(RED, 1, 1);
        checkBoard("#1", B, 1, 1, 2, RED);
        B.addSpot(BLUE, 2, 1);
        checkBoard("#2", B, 1, 1, 2, RED, 2, 1, 2, BLUE);
        B.addSpot(RED, 1, 1);
        checkBoard("#3", B, 1, 1, 1, RED, 2, 1, 3, RED, 1, 2, 2, RED);
        B.undo();
        checkBoard("#2U", B, 1, 1, 2, RED, 2, 1, 2, BLUE);
        B.undo();
        checkBoard("#1U", B, 1, 1, 2, RED);
        B.undo();
        checkBoard("#0U", B);
    }

    /** Checks that B conforms to the description given by CONTENTS.
     *  CONTENTS should be a sequence of groups of 4 items:
     *  r, c, n, s, where r and c are row and column number of a square of B,
     *  n is the number of spots that are supposed to be there and s is the
     *  color (RED or BLUE) of the square.  All squares not listed must
     *  be WHITE with one spot.  Raises an exception signaling a unit-test
     *  failure if B does not conform. */
    private void checkBoard(String msg, Board B, Object... contents) {
        for (int k = 0; k < contents.length; k += 4) {
            String M = String.format("%s at %d %d", msg, contents[k],
                                     contents[k + 1]);
            assertEquals(M, (int) contents[k + 2],
                         B.get((int) contents[k],
                               (int) contents[k + 1]).getSpots());
            assertEquals(M, contents[k + 3],
                         B.get((int) contents[k],
                               (int) contents[k + 1]).getSide());
        }
        int c;
        c = 0;
        for (int i = B.size() * B.size() - 1; i >= 0; i -= 1) {
            assertTrue("bad white square #" + i,
                       (B.get(i).getSide() != WHITE)
                       || (B.get(i).getSpots() == 1));
            if (B.get(i).getSide() != WHITE) {
                c += 1;
            }
        }
        assertEquals("extra squares filled", contents.length / 4, c);
    }

}
