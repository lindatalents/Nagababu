package com.nagababu.fileprocessor;

import com.nagababu.processor.FileProcessor;
import com.nagababu.processor.LocalFileProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;


public class FileProcessorTest {


    @Test
    public void processFileTestAsc() throws Exception {
        FileProcessor f = new LocalFileProcessor("asc");
        List<String> s =f.processFile("TestFile.txt");
        Assert.assertTrue(s.size()==5);
        Assert.assertTrue(s.get(0).compareTo(s.get(s.size()-1))<-1);
    }

    @Test
    public void processFileTestDesc() throws Exception {
        FileProcessor f = new LocalFileProcessor("desc");
        List<String> s =f.processFile("TestFile.txt");

        Assert.assertTrue(s.get(0).compareTo(s.get(s.size()-1))>-1);
    }

    @Test
    public void processFileTestDefaultOrder() throws Exception {
        FileProcessor f = new LocalFileProcessor("desc");
        List<String> s =f.processFile("TestFile.txt");
        Assert.assertTrue(s.get(0).compareTo(s.get(s.size()-1))>-1);
    }


    @Test(expected =  FileNotFoundException.class)
    public void processFileTestWithFileNotFoundExceptionTest() throws Exception {
        FileProcessor f = new LocalFileProcessor("desc");
        List<String> s =f.processFile("TestFile1.txt");
        Assert.assertTrue(s.get(0).compareTo(s.get(s.size()-1))>-1);
    }



}
