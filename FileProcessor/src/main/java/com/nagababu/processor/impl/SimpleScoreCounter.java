package com.nagababu.processor.impl;

import com.nagababu.processor.ScoreCounter;
import org.apache.log4j.Logger;

import java.util.List;

public class SimpleScoreCounter implements ScoreCounter{
    static Logger logger = Logger.getLogger(ScoreCounter.class);

    // total to be returned
    Long totalForAllWord;

    public SimpleScoreCounter(){
        totalForAllWord = 0L;
    }

    /*
        this method takes the list of words as input and returns the final count
     */
    public Long scoreCounterForAllWords(List<String> wordList) throws Exception {
        int i = 0;
        int wordValuePeritsOrder = 0;
        totalForAllWord=0L;
        for(String str : wordList) {
            i++;
            int wordTotalSum = sumString(str);
            wordValuePeritsOrder = wordTotalSum*i;
            logger.info(" word score("+ wordTotalSum +") * order ("+i+")  "+wordValuePeritsOrder);
            totalForAllWord +=wordValuePeritsOrder;
        }
        return totalForAllWord;
    }


    /*
    this method takes word as an input and returns the count for that string
     */
    public int sumString(final String str) throws Exception {
        logger.info(" Sum for Word "+str);
        int sum = 0;
        for (char ch : str.replace("\"", "").toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sum += 1 + ch - 'A';
            }else if (ch >= 'a' && ch <= 'z') {
                sum += 1 + ch - 'a';
            }
            else {
                throw new Exception("File Processor Only Support Alphabet [A-Z] and [a-z]");
            }
        }
        logger.info(" coount for "+sum);
        return sum;
    }
}
