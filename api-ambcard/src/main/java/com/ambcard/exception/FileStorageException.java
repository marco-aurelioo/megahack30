package com.ambcard.exception;

public class FileStorageException extends Throwable {

    public FileStorageException(String s,Throwable t) {
        super(s,t);
    }

    public FileStorageException(String s){
        super(s);
    }

}
