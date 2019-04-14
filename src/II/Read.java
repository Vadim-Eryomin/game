package II;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    public Read(String path) throws IOException {
        FileReader fr = new FileReader(path);
        Scanner name = new Scanner(fr);
    }
}
