package com.green.firstproject.tourschedule.scheduleexception;

public class ScheduleSaveFailedException extends RuntimeException {
    public ScheduleSaveFailedException(String msg) {
        super(msg);
    }
}
