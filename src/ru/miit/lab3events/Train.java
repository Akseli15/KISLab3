package ru.miit.lab3events;

public class Train {
    private String destination;
    private String time;
    private String date;

    public Train(String destination, String time, String date) {
        this.destination = destination;
        this.time = time;
        this.date = date;
    }

    public boolean matches(PassengerRequest request) {
        return this.destination.equals(request.getDestination()) &&
                this.time.equals(request.getTime()) &&
                this.date.equals(request.getDate());
    }

    @Override
    public String toString() {
        return "Train{" +
                "destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
