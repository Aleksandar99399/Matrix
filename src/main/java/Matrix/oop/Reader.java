package Matrix.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader extends BufferedReader {

    public Reader() {
        super(new InputStreamReader(System.in));
    }
}
