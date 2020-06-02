package neu.lab.match;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

/**
 * @author SUNJUNYAN
 */
public class AcquireXml {

    public static void main(String[] args) throws DocumentException, IOException {
        String targetPath = "E:\\Sensor\\Result2\\RiskLevel\\";
        File file = new File("E:\\Sensor\\Result2\\");
        int num = 0;
        if (file.exists()) {

            if (file.listFiles().length > 0) {
                for (File innerDir : file.listFiles()) {
                    System.out.println(innerDir.getPath());
                    if (check(innerDir)) {
                        System.out.println("target");
                        Files.copy(innerDir.toPath(), new File(targetPath + innerDir.getName()).toPath());
                    }
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    public static boolean check(File file) throws DocumentException {

        boolean isTrue = false;
        if (!file.exists() || file.length() == 0) {
            isTrue = false;
        } else {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);

            Element rootElement = document.getRootElement();
            if (rootElement != null) {
                List<Element> conflicts = rootElement.elements("conflicts");
                for (Element conflict : conflicts) {
                    Element conflictJar = conflict.element("conflictJar");

                    List<Attribute> listAttr = conflictJar.attributes();
                    for (Attribute attribute : listAttr) {
                        System.out.println(attribute.getName() + ":" + attribute.getValue());
                        if ("riskLevel".equals(attribute.getName())) {
                            if ("3".equals(attribute.getValue()) || "4".equals(attribute.getValue())) {
                                System.out.println(attribute.getName() + ":" + attribute.getValue());
                                isTrue = true;
                            }
                        }
                    }
                }
            }
        }
        return isTrue;
    }
}
