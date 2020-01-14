package com.fengf.common.utils;

import com.fengf.common.exception.ArgsNotValidException;

public class ArgsValidUtil {

    public static void checkIsNotNull(Object...args){
        for (Object arg : args){
            if (arg == null){
                throw new ArgsNotValidException("some arg is null");
            }
        }
    }
    public static void checkIsNotBlack(Object...args){
        for (Object arg : args){
            checkIsNotNull(args);
            if (arg.toString().isEmpty()){
                throw new ArgsNotValidException("some arg is empty");
            }
        }
    }

}
