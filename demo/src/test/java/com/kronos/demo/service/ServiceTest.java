package com.kronos.demo.service;

import com.kronos.demo.model.Flight;
import com.kronos.demo.service.impl.AdminFlightServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ServiceTest {

    @Test
    public void flightTest() {
        AdminFlightService service = new AdminFlightServiceImpl();
        Flight flight = new Flight();
        boolean success = service.add(flight);
        Assert.isTrue(success, "");
        System.out.println(success);
    }

    @Test
    public void appTest() {

    }
}
