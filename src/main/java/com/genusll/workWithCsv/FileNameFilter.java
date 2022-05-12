package com.genusll.workWithCsv;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilter implements FilenameFilter {
    private final String ext;
    public FileNameFilter(String ext){
        this.ext = ext.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}
