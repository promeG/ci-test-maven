import java.io.File;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void main() {
        File dir = new File("/home/travis/.m2/");
        showFiles(dir.listFiles());
    }

    private void showFiles(File[] files) {
        if (files == null) {
            System.out.println("Directory: null");
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}