import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void main() throws IOException {
        File dir = new File("/home/travis/");
        final Path root = Paths.get(dir.getAbsolutePath());

        final int maxDepth = 3;

        Files.walk(root, maxDepth)
                .skip(1)
                .filter(Files::isDirectory)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);

        System.out.println("==================");

        showFiles(new File("/home/travis/.m2/").listFiles());

//        File testFile = new File(new File("/home/travis/.m2/repository/org/example/ci-test-maven/"), "test.txt");
//        FileWriter fw = new FileWriter(testFile);
//        fw.write("hello");
//        fw.close();

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