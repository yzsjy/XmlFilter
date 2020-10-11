package neu.lab.match;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AcquireText {
    public static void main(String[] args) throws IOException {
        String targetPath = "C:\\Users\\SUNJUNYAN\\Desktop\\ResultFilter\\R_Class\\";
        File file = new File("C:\\Users\\SUNJUNYAN\\Desktop\\TestResult\\R_Class\\");
        int num = 0;
        if (file.exists()) {

            if (!new File(targetPath).exists()) {
                new File(targetPath).mkdirs();
            }
            if (file.listFiles().length > 0) {
                for (File logFile : file.listFiles()) {
                    System.out.println(logFile.getPath());
                    if (check(logFile)) {
                        System.out.println("target");
                        Files.copy(logFile.toPath(), new File(targetPath + logFile.getName()).toPath());
                    }
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    public static boolean check(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.contains("conflict : ")) {
                return true;
            }
        }

        //close
        inputStream.close();
        bufferedReader.close();

        return false;
    }

    public void getInfo(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            int i = 1;
            while ((str = bufferedReader.readLine()) != null) {
                if (i == 1) {

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
