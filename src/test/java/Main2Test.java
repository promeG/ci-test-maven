import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main2Test {

    @org.junit.Test
    public void main() throws IOException {

        System.out.println("<<<<<<<<<<<<<");
        File testFile = new File(new File("/home/travis/.m2/repository/org/example/ci-test-maven/"), "test.txt");
        byte[] encoded = Files.readAllBytes(Paths.get(testFile.getAbsolutePath()));
        String result =  new String(encoded, StandardCharsets.UTF_8);
        System.out.println(">>>>>>>>>>\t" + result);
    }
}