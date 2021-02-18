package com.nagababu.processor.impl;

import com.nagababu.processor.ScoreCounter;

import java.util.List;

/*
This class can be utilized when we come up with
any formulea to calcualte score
* */
public class FormulatedScoreCounter implements ScoreCounter {
    @Override
    public Long scoreCounterForAllWords(List<String> wordList) throws Exception {
        throw new Exception("Method not supported");
    }

    @Override
    public int sumString(String str) throws Exception {
        throw new Exception("Method not supported");
    }
}
