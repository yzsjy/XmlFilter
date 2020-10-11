package neu.lab.match;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReplaceString {
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
        List<String> pomPaths = getPomPath("C:\\Users\\SUNJUNYAN\\Desktop\\whole.txt");
        List<String> temp = new ArrayList<String>();
        for (String pomPath : pomPaths) {
            temp.add(pomPath.replace("/", "\\"));
        }
        try {
            PrintWriter printer_A = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\SUNJUNYAN\\Desktop\\whole1.txt"), true)));
            for (String a : temp) {
                printer_A.println(a);
            }
            printer_A.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
