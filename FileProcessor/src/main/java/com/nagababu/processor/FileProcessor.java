package com.nagababu.processor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;



import com.nagababu.main.PrototypeLauncher;
/*
* This class takes care of processing of file
* 1) reading file,
* 2) process each line
* 3) splitting by comma all the words
* 4) sorting the words
*/
public interface FileProcessor {
	public List<String> processFile(String fileNamePath) throws Exception;

}
