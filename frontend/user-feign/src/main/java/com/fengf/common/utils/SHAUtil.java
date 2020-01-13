package com.fengf.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtil {
    private final static Logger logger = LoggerFactory.getLogger(SHAUtil.class);

    public static String sha(String word) {
        String string = word;
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
            sha.update(word.getBytes());
            string = new BigInteger(sha.digest()).toString(32);
        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
            logger.error("SHAUitl error | " + e);
        }
        return string;

    }
}
