package com.bridgelabs;

public class CensusAnalyserException extends Throwable {

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, NOT_A_CSV_TYPE, UNABLE_TO_PARSE

    }
    public ExceptionType type;


    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
