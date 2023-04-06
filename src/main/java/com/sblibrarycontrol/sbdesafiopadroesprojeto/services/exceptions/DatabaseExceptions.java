package com.sblibrarycontrol.sbdesafiopadroesprojeto.services.exceptions;

public class DatabaseExceptions extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public DatabaseExceptions(String msg){
        super(msg);
    }
}
