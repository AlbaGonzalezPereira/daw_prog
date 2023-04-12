package utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataReader {
    public static String[] read(String filename) throws IOException {
        Path path=FileSystems.getDefault().getPath(filename);
        return Files.readAllLines(path).toArray(new String[0]);
    } 
}
