package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IO {

    public static String readFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

    public static int getFileNum(String folder_path, String keyword) throws IOException {
        try (Stream<Path> files = Files.list(Paths.get(folder_path))) {
            return (int) files
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().contains(keyword))
                    .count();
        }
    }
}
