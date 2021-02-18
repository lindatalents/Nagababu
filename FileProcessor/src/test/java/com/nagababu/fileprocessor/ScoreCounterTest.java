package com.nagababu.fileprocessor;

import com.nagababu.processor.ScoreCounter;
import com.nagababu.processor.impl.SimpleScoreCounter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ScoreCounterTest {

    @Test
    public void sumStrTest() throws Exception {
        ScoreCounter f = new SimpleScoreCounter();
        Assert.assertTrue(f.sumString("abcd")==10);

    }
    @Test
    public void sumStrTestWithEmptyStringTest() throws Exception {
        ScoreCounter f = new SimpleScoreCounter();
        Assert.assertTrue(f.sumString("")==0);

    }

    @Test
    public void scoreCounterForAllWordsTest() throws Exception {
        ScoreCounter f = new SimpleScoreCounter();
        Assert.assertTrue(f.scoreCounterForAllWords(Arrays.asList("abcd","efgh"))==62);
        Assert.assertTrue(f.scoreCounterForAllWords(Arrays.asList(""))==0);

    }

    @Test
    public void scoreCounterForAllWordsWithEmptyList() throws Exception {
        ScoreCounter f = new SimpleScoreCounter();
        Assert.assertTrue(f.scoreCounterForAllWords(Arrays.asList(""))==0);

    }

    @Test(expected = Exception.class)
    public void sumStrTestWithExceptionTest() throws Exception {
        ScoreCounter f = new SimpleScoreCounter();
        Assert.assertTrue(f.sumString("ab1cd")==10); // string contains digits which raises to exception

    }


}
