package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class  MainService {
    public static Path doService() throws IOException {
        ResourceBundle rb = ResourceBundle.getBundle("messages", Locale.getDefault());
        System.out.println(rb.getString("serviceInit"));

        Path serviceDirPath = Paths.get("servicePack");
        Path serviceFilePath = Paths.get(serviceDirPath.toString(), "service.txt");

        Files.createDirectories(serviceDirPath);
        String content = "Service content.";
        Path serviceFile = Files.writeString(serviceFilePath, content);

        System.out.println(rb.getString("serviceCompleted"));

        return serviceFile;
    }
}
