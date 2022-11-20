import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        String data = "";
        try {
            File testFile = new File("NoError3.txt");
            try (Scanner reader = new Scanner(testFile)) {
                while (reader.hasNextLine()) {
                    data += reader.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Lexical.lex(data, Lexical.keywordsAndOps);
        System.out.println(Lexical.list.toString());
        Syntax.Syntax_Analyze();
    }

}
