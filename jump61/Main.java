package jump61;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.Writer;
import ucb.util.CommandArgs;

/** The jump61 game.
 * @author Rafayel Mkrtchyan
 */

public class Main {

    /** Size of the buffer used for commands from the GUI. */
    static final int COMMAND_BUFFER_SIZE = 2048;

    /** Location of usage message resource. */
    static final String USAGE = "jump61/Usage.txt";

    /** Play jump61.  ARGS0 may consist of the single string
     *  '--display' to indicate that the game is played using a GUI. Prints
     *  a usage message if the arguments are wrong. */
    public static void main(String[] args0) {
        CommandArgs args =
            new CommandArgs("--display{0,1}", args0);

        if (!args.ok()) {
            usage();
            return;
        }

        Game game;
        if (args.contains("--display")) {
            try {
                Writer trash = new FileWriter("/dev/null");
                PipedWriter commandWriter = new PipedWriter();
                PipedReader commandReader =
                    new PipedReader(commandWriter, COMMAND_BUFFER_SIZE);
                game = new Game(commandReader, trash, trash, trash);
                Display display = new Display("Jump61", game, commandWriter);
                game.play();
            } catch (IOException excp) {
                game = null;
                System.err.println("Internal error");
                System.exit(1);
            }
        } else {
            Writer output = new OutputStreamWriter(System.out);
            game = new Game(new InputStreamReader(System.in),
                            output, output,
                            new OutputStreamWriter(System.err));
            System.exit(game.play());
        }
    }

    /** Print the contents of the resource named NAME on OUT.
     *  NAME will typically be a file name based in one of the directories
     *  in the class path.  */
    static void printHelpResource(String name, PrintWriter out) {
        try {
            InputStream resource =
                Main.class.getClassLoader().getResourceAsStream(name);
            BufferedReader str =
                new BufferedReader(new InputStreamReader(resource));
            for (String s = str.readLine(); s != null; s = str.readLine())  {
                out.println(s);
            }
            str.close();
            out.flush();
        } catch (IOException excp) {
            out.printf("No help found.");
            out.flush();
        }
    }

    /** Print usage message. */
    private static void usage() {
        printHelpResource(USAGE, new PrintWriter(System.err));
    }

}
