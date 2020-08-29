package com.kronos.demo.service;

import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminFlightService {

    boolean add(Flight flight);

    boolean update(Flight flight);

    boolean delete(long id);

    Flight getFlightById(long id);

    List<Flight> batchFlight(FlightParam param);

    List<Flight> sort();
}
