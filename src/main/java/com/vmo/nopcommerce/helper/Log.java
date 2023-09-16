package com.vmo.nopcommerce.helper;



import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;


public class Log {
    private static Logger logger = LogManager.getLogger(Log.class);
    public static void info(String message){
        logger.info(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }

}
