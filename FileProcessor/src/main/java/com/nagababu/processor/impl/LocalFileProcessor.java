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
public class LocalFileProcessor implements FileProcessor{

    public static Logger logger = Logger.getLogger(FileProcessor.class.getName());

    private String sortOrder;

    public LocalFileProcessor(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /*
    File process logic is handled by this method by taking file path as a parameter
     */
    public List<String> processFile(String fileNamePath) throws FileNotFoundException {
        List<String> wordExtractLst  = readFile(fileNamePath);
        logger.info("Before Order "+wordExtractLst.toString());
        sortListinOrder(wordExtractLst);
        logger.info("After Order "+wordExtractLst.toString());
        return wordExtractLst;
    }


    private List<String> readFile(String fileNamePath) throws FileNotFoundException {
        logger.info(" Read a File from provided location");
        InputStream inputStream = new FileInputStream(new File(fileNamePath));
        Scanner scanner = new Scanner(inputStream);
        List<String> wordExtractLst = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            wordExtractLst = processLine(line);
        }
        scanner.close();
        return wordExtractLst;
    }

    /*
    this method plays the vital role by taking the line and processing as per the given terms
     */
    private List<String> processLine(String line) {
        logger.info(" process each line seprated word");
        String[] allWordsInLine = splitInputByComma(line);
        List<String> wordExtractLst = new ArrayList<>();
        if (allWordsInLine != null) {
            for (String word : allWordsInLine) {
                wordExtractLst.add(word);
            }
        }
        return wordExtractLst;

    }

    private String[] splitInputByComma(String line) {
        String[] splitLineByComma = line.split(",");
        return splitLineByComma;
    }

    private void sortListinOrder(List<String> wordExtractLst) {
        logger.info(" sort all word in natural order");
        if(this.sortOrder.equals("desc"))
            wordExtractLst.sort(Collections.reverseOrder());
        else
            wordExtractLst.sort(Comparator.naturalOrder());

    }

}
