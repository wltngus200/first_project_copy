package com.green.firstproject.tourschedule.scheduleexception;

public class ScheduleRequiredException extends RuntimeException {
    public ScheduleRequiredException(String msg) {
        super(msg);
    }
}
