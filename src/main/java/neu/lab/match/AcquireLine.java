package neu.lab.match;

import java.io.*;

/**
 * @author SUNJUNYAN
 */
public class AcquireLine {
    public static void main(String[] args) throws IOException {
        String txtPath = "C:\\Users\\SUNJUNYAN\\Desktop\\abc.txt";
        String outPath = "C:\\Users\\SUNJUNYAN\\Desktop\\project.txt";
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File(outPath), true)));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(txtPath))));
        String lineText = null;
        while ((lineText = bufferedReader.readLine()) != null) {
            String line = lineText.split(" ")[0];
            printer.println(line);
        }
        bufferedReader.close();
        printer.close();
    }
}
