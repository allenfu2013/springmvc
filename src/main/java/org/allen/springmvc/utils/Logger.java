package org.allen.springmvc.utils;


public class Logger {

    public static void info(Class clazz, String msg) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(clazz);
        logger.info(msg);
    }

    public static void info(Object obj, String msg) {
        info(obj.getClass(), msg);
    }

    public static void error(Class clazz, String msg, Throwable e) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(clazz);
        if (e != null) {
            logger.error(msg, e);
        } else {
            logger.error(msg);
        }
    }

    public static void error(Object obj, String msg, Throwable e) {
        error(obj.getClass(), msg, e);
    }

    public static void warn(Class clazz, String msg, Throwable e) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(clazz);
        if (e != null) {
            logger.warn(msg, e);
        } else {
            logger.warn(msg);
        }
    }

    public static void warn(Object obj, String msg, Throwable e) {
        warn(obj.getClass(), msg, e);
    }

}
