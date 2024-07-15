package com.etienne;

import java.util.List;

public class PhoneSubscriber extends Subscriber{

    // only for demonstration - open for modification
    @Override
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*baseRate/100;
    }

}