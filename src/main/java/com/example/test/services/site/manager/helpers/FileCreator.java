package com.example.test.services.site.manager.helpers;

import java.io.File;

public class FileCreator {
    public File createsNewFiles(int i) {
        File file = new File("Files/file" + i + ".txt");
        return file;
    }
}
