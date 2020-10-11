package neu.lab.match;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SUNJUNYAN
 */
public class StringMatch {

    private static List<String> getPomPath(String file) {
        ArrayList pomPaths = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.equals("")) {
                    System.out.println(line);
                    pomPaths.add(line);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pomPaths;
    }

    public static void main(String[] args) {
        List<String> string_A = getPomPath("E:\\test\\T.txt");
        List<String> string_B = getPomPath("E:\\test\\Project_build_success.txt");
        List<String> temp_A = new ArrayList<String>();
        List<String> temp_B = new ArrayList<String>();
        for (String a : string_A) {
            for (String b : string_B) {
                if (a.contains(b)) {
                    temp_A.add(a);
                    break;
                }
            }
        }
        for (String a : string_A) {
            if (!temp_A.contains(a)) {
                temp_B.add(a);
            }
        }
        try {
            PrintWriter printer_A = new PrintWriter(new BufferedWriter(new FileWriter(new File("E:\\test\\success.txt"), true)));
            for (String a : temp_A) {
                printer_A.println(a);
            }
            printer_A.close();

            PrintWriter printer_B = new PrintWriter(new BufferedWriter(new FileWriter(new File("E:\\test\\fail.txt"), true)));
            for (String b : temp_B) {
                printer_B.println(b);
            }
            printer_B.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
