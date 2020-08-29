package com.kronos.demo.param;

import java.util.Date;

public class FlightParam {
    private String flightId;

    private Date takeoff;

    private Date arrive;

    private String departure;

    private String destination;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Date getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(Date takeoff) {
        this.takeoff = takeoff;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
