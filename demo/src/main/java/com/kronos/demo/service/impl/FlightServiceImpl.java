package com.kronos.demo.service.impl;

import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;
import com.kronos.demo.service.FlightService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private List<Flight> flights;

    public boolean add(Flight flight) {
        flights.add(flight);
        return true;
    }

    public boolean update(Flight flight) {
        return false;
    }

    public boolean delete(long id) {
        int length = flights.size();
        for (int i = 0; i < length; i++) {
            if (flights.get(i).getId() == id) {
                flights.remove(i);
                return true;
            }
        }
        return false;
    }

    public Flight getFlightById(long id) {
        return null;
    }

    public List<Flight> batchFlight(FlightParam param) {
        return null;
    }

    public FlightServiceImpl() {
        init();
    }

    private void init() {
        flights = new ArrayList<>();
        Flight flight = new Flight();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        flight.setId(1L);
        try {
            flight.setTakeoff(sdf.parse("2020-08-27 10:00:00"));
            flight.setArrive(sdf.parse("2020-08-27 14:00:00"));
            flight.setFlightId("ABC-123");
            flight.setGmtCreated(new Date());
            flight.setGmtModified(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flights.add(flight);
    }
}
