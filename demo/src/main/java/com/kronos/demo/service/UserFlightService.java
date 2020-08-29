package com.kronos.demo.service;

import com.kronos.demo.model.Bill;
import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;

import java.util.List;

public interface UserFlightService {
    boolean order(Bill bill, long accountId);

    boolean cancel(long billId, long accountId);

    List<Flight> queryFlight(FlightParam param);

    List<Bill> getBills(long accountId);
}
