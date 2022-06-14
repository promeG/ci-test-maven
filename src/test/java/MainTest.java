import java.io.File;
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
                .map(Path::getFileName)
                .forEach(System.out::println);

//        showFiles(dir.listFiles());
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