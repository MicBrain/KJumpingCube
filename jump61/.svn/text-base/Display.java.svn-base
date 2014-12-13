package jump61;
import ucb.gui.TopLevel;
import ucb.gui.LayoutSpec;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Observable;
import java.util.Observer;
import static jump61.Side.*;

/** The GUI controller for jump61.  To require minimal change to textual
 *  interface, we adopt the strategy of converting GUI input (mouse clicks)
 *  into textual commands that are sent to the Game object through a
 *  a Writer.  The Game object need never know where its input is coming from.
 *  A Display is an Observer of Games and Boards so that it is notified when
 *  either changes.
 *  @author Rafayel Mkrtchyan
 */
class Display extends TopLevel implements Observer {

    /** A new window with given TITLE displaying GAME, and using COMMANDWRITER
     *  to send commands to the current game. */
    Display(String title, Game game, Writer commandWriter) {
        super(title, true);
        _game = game;
        _board = game.getBoard();
        _commandOut = new PrintWriter(commandWriter);
        _boardWidget = new BoardWidget(game, _commandOut);
        add(_boardWidget, new LayoutSpec("y", 1, "width", 2));
        addMenuButton("Game->Start Game", "start");
        addMenuButton("Size->2", "size2");
        addMenuButton("Size->3", "size3");
        addMenuButton("Size->4", "size4");
        addMenuButton("Size->5", "size5");
        addMenuButton("Size->6", "size6");
        addMenuButton("Size->7", "size7");
        addMenuButton("Size->8", "size8");
        addMenuButton("Size->9", "size9");
        addMenuButton("Size->10", "size10");
        addMenuButton("Manual->Set Manual", "manual");
        addMenuButton("Auto->Set Auto", "auto");
        addMenuButton("Game->Clear Game", "clear");
        addMenuButton("Game->Quit", "quit");
        _board.addObserver(this);
        _game.addObserver(this);
        display(true);
    }

    /** Response to "Help" button click. */
    void start(String dummy) {
        _commandOut.printf("start%n");
    }

    /** Response to "Size" button click. */
    void size2(String dummy) {
        _commandOut.printf("size %d%n", 2);
    }

    /** Response to "Size" button click. */
    void size3(String dummy) {
        _commandOut.printf("size %d%n", 3);
    }

    /** Response to "Size" button click. */
    void size4(String dummy) {
        _commandOut.printf("size %d%n", 4);
    }

    /** Response to "Size" button click. */
    void size5(String dummy) {
        _commandOut.printf("size %d%n", 5);
    }

     /** Response to "Size" button click. */
    void size6(String dummy) {
        _commandOut.printf("size %d%n", 6);
    }

    /** Response to "Size" button click. */
    void size7(String dummy) {
        _commandOut.printf("size %d%n", 7);
    }

    /** Response to "Size" button click. */
    void size8(String dummy) {
        _commandOut.printf("size %d%n", 8);
    }

    /** Response to "Size" button click. */
    void size9(String dummy) {
        _commandOut.printf("size %d%n", 9);
    }

    /** Response to "Size" button click. */
    void size10(String dummy) {
        _commandOut.printf("size %d%n", 10);
    }

    /** Response to "Size" button click. */
    void auto(String dummy) {
        _commandOut.printf("auto red%n");
    }

    /** Response to "Help" button click. */
    void manual(String dummy) {
        _commandOut.printf("manual blue%n");
    }

    /** Response to "Help" button click. */
    void clear(String dummy) {
        _commandOut.printf("clear%n");
    }

    /** Response to "Quit" button click. */
    void quit(String dummy) {
        System.exit(0);
    }

    @Override
    public void update(Observable obs, Object obj) {
        _boardWidget.update();
        frame.pack();
        _boardWidget.repaint();
    }

    /** The current game that I am controlling. */
    private Game _game;
    /** The board maintained by _game (readonly). */
    private Board _board;
    /** The widget that displays the actual playing board. */
    private BoardWidget _boardWidget;
    /** Writer that sends commands to our game. */
    private PrintWriter _commandOut;
}
