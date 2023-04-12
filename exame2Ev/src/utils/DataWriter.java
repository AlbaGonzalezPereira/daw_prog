package utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class DataWriter {
    public static Path write(String filename,String[] data) throws IOException {
        Path path=FileSystems.getDefault().getPath(filename);
        return Files.write(path,Arrays.asList(data), Charset.defaultCharset());
    }
}
