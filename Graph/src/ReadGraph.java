import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author LiSheng
 * @date 2020/2/12 11:34
 */
public class ReadGraph {
    private Scanner scanner;

    public ReadGraph(Graph graph, String filename) {
        readFile(filename);
        try {
            int V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            }
            if (V == graph.V()) {
                int E = scanner.nextInt();
                if (E < 0) {
                    throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
                }
                for (int i = 0; i < E; i++) {
                    int v = scanner.nextInt();
                    int w = scanner.nextInt();
                    if (v >= 0 && v < V && w >= 0 && w < V) {
                        graph.addEdge(v, w);
                    }
                }
            }
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String filename) {
        if (filename != null) {
            try {
                File file = new File(filename);
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    scanner = new Scanner(new BufferedInputStream(fis));
                    scanner.useLocale(Locale.ENGLISH);
                }else {
                    throw new IllegalArgumentException(filename+" doesn't exist.");
                }
            } catch (IOException ioe) {
                throw new IllegalArgumentException("Could not open " + filename, ioe);
            }
        }
    }
}
