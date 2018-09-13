package com.example.test.services.site.manager.helpers;

import com.example.test.lawyerDTO.Lawyer;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.List;

public class DataWriter {

    public void writesDataAsJson(File file, List<Lawyer> list) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Lawyer>>() {
        }.getType();
        List<Lawyer> lawyerList = list;
        String json = gson.toJson(lawyerList, type);
        Files.write(file.toPath(), json.getBytes());
        lawyerList.clear();
    }
}
