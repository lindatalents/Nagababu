package com.nagababu.processor.impl;

import com.nagababu.processor.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

/*
This Class can be used when files are stored in remote servers
we can implement through rest calls

 */
public class RemotFileProcessor implements FileProcessor {

    @Override
    public List<String> processFile(String fileNamePath) throws Exception {
        throw new Exception("Method not supported");
    }
}
