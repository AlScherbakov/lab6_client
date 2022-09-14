package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Input source manager: standard input or file BufferedReader
 */

public class DataInputSource {
    private Scanner scan = null;
    private BufferedReader reader = null;
    public DataInputSource(Scanner scan){
        this.scan = scan;
    }
    public DataInputSource(BufferedReader reader){
        this.reader = reader;
    }
    public String get() throws IOException {
        String str = scan != null ? scan.nextLine() : reader != null ? reader.readLine() : null;
        if (str != null){
            return str.trim();
        }
        return "";
    }
}
