package com.kronos.demo.service.impl;

import com.kronos.demo.model.Bill;
import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;
import com.kronos.demo.service.UserFlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFlightServiceImpl implements UserFlightService {

    @Override
    public boolean order(Bill bill, long accountId) {
        return false;
    }

    @Override
    public boolean cancel(long billId, long accountId) {
        return false;
    }

    @Override
    public List<Flight> queryFlight(FlightParam param) {
        return null;
    }

    @Override
    public List<Bill> getBills(long accountId) {
        return null;
    }
}
