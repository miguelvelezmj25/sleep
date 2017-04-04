package edu.cmu.cs.mvelezce.sleep;
import java.io.File;
import java.util.Scanner;
/**
 * This is a helper class for the language.
 *
 * @author Miguel Velez - miguelvelezmj25
 * @version 0.1.0.2
 */
public class Helper {

    /**
     * Loads the program.
     *
     * @param name
     * @return
     * @throws Exception
     */
    public static String loadFile(String name) throws Exception {
        Scanner s = new Scanner(new File(name));
        String file = "";
        while (s.hasNext()) {
            file += s.nextLine() + "\n";
        }
        s.close();
        return file;
    }

}
