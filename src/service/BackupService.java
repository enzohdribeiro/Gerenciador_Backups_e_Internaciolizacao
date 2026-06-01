package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class BackupService {

    public static void createBackup(Path file) throws IOException{
        ResourceBundle rb = ResourceBundle.getBundle("messages", Locale.getDefault());
        System.out.println(rb.getString("backupInit"));

        Path backupDirPath = Paths.get("Backup");
        Path backupFilePath = Paths.get(backupDirPath.toString(), "backup.txt");
        Files.createDirectories(backupDirPath);

        Files.copy(file, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(rb.getString("backupCompleted"));
    }
}
