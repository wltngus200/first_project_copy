package com.green.firstproject.tourschedule.scheduleexception;

public class DuplicateScheduleException extends RuntimeException {
    public DuplicateScheduleException(String msg) {
        super(msg);
    }

}
