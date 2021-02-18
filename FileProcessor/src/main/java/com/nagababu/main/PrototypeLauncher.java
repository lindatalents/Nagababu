package com.nagababu.main;

import com.nagababu.processor.FileProcessor;
import com.nagababu.processor.LocalFileProcessor;
import com.nagababu.processor.ScoreCounter;
import com.nagababu.processor.impl.SimpleScoreCounter;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.List;

/*
*
* This is the main class which takes the file as an argument and
* initiates the score counter.
*/
public class PrototypeLauncher {

	static Logger logger = Logger.getLogger(PrototypeLauncher.class);

    public Long processFileAndGetScore(String fileNamePath,String sortOrder){
		Long totalSum=0L;
		List<String> wordExtractLst = null;
		try {

			FileProcessor fileProcessor = new LocalFileProcessor(sortOrder);
			wordExtractLst = fileProcessor.processFile(fileNamePath);
			ScoreCounter scoreCounter = new SimpleScoreCounter();
			totalSum = scoreCounter.scoreCounterForAllWords(wordExtractLst);
			logger.info(totalSum);

		} catch (FileNotFoundException exception) {
			logger.error("File Not Found Exeption");
		} catch (Exception exception) {
			logger.error(exception);
		}
		return totalSum;
	}

	public static void main(String[] args) {
		PrototypeLauncher pl = new PrototypeLauncher();
		System.out.println("Total Score of the given File is:" + pl.processFileAndGetScore(args[0], args[1]));
    }
}
