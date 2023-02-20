package com.bridgelabs;


import com.bridgelabs.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_TYPE = "./src/test/resources/IndiaStateCensusData.txt";
    private static final String SAMPLE_CSV_DELIMITERS = "./src/test/resources/SampleFileDelimiter.csv";
    private static final String SAMPLE_CSV_HEADER = "./src/test/resources/SampleFileHeader.csv";

    // India State Code Information
    private static final String STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_TYPE = "./src/test/resources/IndiaStateCode.txt";
    private static final String SAMPLE_STATE_CODE_DELIMITER = "./src/test/resources/SampleStateCodeDelimiter.txt";
    private static final String SAMPLE_STATE_CODE_HEADER = "./src/test/resources/SampleStateCodeHeader.csv";

    CensusAnalyser censusAnalyser = new CensusAnalyser();


    // UC1 - Test cases for Indian State Census Information
    @Test
    public void given_IndianCensusCSVFile_ReturnsCorrectRecords() throws CensusAnalyserException {
        int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        Assert.assertEquals(29, numOfRecords);
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void  givenIndiaCensusData_WhenWrongType_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_TYPE);
        } catch (CensusAnalyserException e){
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenDelimiterIncorrect_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaCensusData(SAMPLE_CSV_DELIMITERS);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenHeaderIncorrect_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaCensusData(SAMPLE_CSV_HEADER);
        } catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    // UC2 - Test Cases for Indian State Code Information

    @Test
    public void given_IndianStateCodeCSVFile_ReturnsCorrectRecords() throws CensusAnalyserException {
        int numOfRecords = censusAnalyser.loadIndiaStateCode(STATE_CODE_CSV_FILE_PATH);
        Assert.assertEquals(37, numOfRecords);
    }


    @Test
    public void givenIndiaStateCodeData_WithWrongFile_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenIndiaStateCodeData_WhenWrongType_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CSV_TYPE);
        } catch (CensusAnalyserException e){
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }


    @Test
    public void givenIndiaStateCodeData_WhenDelimiterIncorrect_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaStateCode(SAMPLE_STATE_CODE_DELIMITER);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }


    @Test
    public void givenIndiaStateCodeData_WhenHeaderIncorrect_ShouldThrowException() {
        try {
            censusAnalyser.loadIndiaStateCode(SAMPLE_STATE_CODE_HEADER);
        } catch (CensusAnalyserException e){
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }
}