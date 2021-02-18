package com.nagababu.fileprocessor;

import com.nagababu.main.PrototypeLauncher;
import org.junit.Assert;
import org.junit.Test;

public class PropertyLauncherTest {
    @Test
    public void processFileAndGetScoreWithAscTest(){
        PrototypeLauncher lpl = new PrototypeLauncher();
        Assert.assertTrue(lpl.processFileAndGetScore("TestFile.txt","asc")==952);

    }
    @Test
    public void processFileAndGetScoreWithDescTest(){
        PrototypeLauncher lpl = new PrototypeLauncher();
        Assert.assertTrue(lpl.processFileAndGetScore("TestFile.txt","desc")==878);

    }

    @Test
    public void processFileAndGetScoreWithWrongFileTest(){
        PrototypeLauncher lpl = new PrototypeLauncher();
        Assert.assertTrue(lpl.processFileAndGetScore("TestFile1.txt","desc")==0);

    }
}
