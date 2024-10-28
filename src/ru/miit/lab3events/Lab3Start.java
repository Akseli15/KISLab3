package ru.miit.lab3events;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Lab3Start {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            PassengerRequest passengerRequest = container.instance().select(PassengerRequest.class).get();

            passengerRequest.createRequest("Москва", "12:00", "2024-11-10");

        } finally {
            weld.shutdown();
        }
    }
}
