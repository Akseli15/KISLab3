package ru.miit.lab3events;

import ru.miit.lab3events.annotation.RequestCreated;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class PassengerRequest {
    private String destination;
    private String time;
    private String date;

    @Inject @RequestCreated
    private Event<PassengerRequest> requestCreatedEvent;

    public void createRequest(String destination, String time, String date) {
        this.destination = destination;
        this.time = time;
        this.date = date;
        requestCreatedEvent.fire(this);
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "PassengerRequest{" +
                "destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
