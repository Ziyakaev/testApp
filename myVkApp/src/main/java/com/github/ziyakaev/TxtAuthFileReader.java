package com.github.ziyakaev;

import sun.security.util.Password;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TxtAuthFileReader implements AuthFileReader {
    List<String> paramList=new ArrayList<>();
    public TxtAuthFileReader(String userDataFile) throws IOException {
        Path path = Paths.get(userDataFile);
        paramList=Files.readAllLines(path);
    }

    @Override
    public AuthVk getAuthVk(int i) {
        List <String>param=Utils.split(String.join("\n",paramList));
        return new AuthVk(param.get(0),param.get(1));
    }
}
