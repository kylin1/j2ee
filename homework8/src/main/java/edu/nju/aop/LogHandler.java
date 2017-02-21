package edu.nju.aop;

/**
 * Created by kylin on 21/02/2017.
 * All rights reserved.
 */
public class LogHandler
{
    public void LogBefore()
    {
        System.out.println("Log before method");
    }

    public void LogAfter()
    {
        System.out.println("Log after method");
    }
}
