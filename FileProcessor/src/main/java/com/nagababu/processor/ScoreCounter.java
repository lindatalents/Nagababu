package com.nagababu.processor;

import java.util.List;

/**
 *
 * This class takes care of counting and maintaining the total value
 * as per the given requirement
 */

public interface ScoreCounter {

	 Long scoreCounterForAllWords(List<String> wordList) throws Exception;
	 int sumString(final String str) throws Exception;

}
