package test;

import service.BackupService;
import service.MainService;

import java.io.IOException;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        Path serviceFile;

        serviceFile = MainService.doService();
        BackupService.createBackup(serviceFile);

    }
}
