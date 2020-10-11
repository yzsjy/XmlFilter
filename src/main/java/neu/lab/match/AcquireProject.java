package neu.lab.match;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AcquireProject {
    public static void main(String[] args) {
        String targetPath = "D:\\wwww\\sjy\\text\\";
        File file = new File("D:\\wwww\\unzip\\");
        List<String> projectList = new ArrayList<String>();
        int num = 0;
        if (file.exists()) {
            if (file.listFiles().length > 0) {
                for (File innerDir : file.listFiles()) {
                    if (!innerDir.exists() && innerDir.isDirectory()) {
                        continue;
                    }
                    projectList.add(innerDir.getAbsolutePath());
                }
            }
        }
        try {
            PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File(targetPath + "cleanList.txt"), true)));
            for (String project : projectList) {
                printer.println(project);
            }
            printer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
