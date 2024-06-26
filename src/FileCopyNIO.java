// Java. Полное руководство - Г.Шилдт
// Копирование файла с использованием системы NIO
// стр. 896

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyNIO {
    public static void main(String[] args) {
        try {
            Path source = Path.of(".\\src\\source.txt");
            Path target = Path.of(".\\src\\target.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("!");
            System.out.println(e.getMessage());
        }
    }
}