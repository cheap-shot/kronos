package com.kronos.demo.service;

import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;
import com.kronos.demo.service.impl.AdminFlightServiceImpl;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FlightTest {
    @Test
    public void removeTest() {
        AdminFlightService service = new AdminFlightServiceImpl();
        service.delete(1L);
    }

    @Test
    public void listTest() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 10, 16, 20);
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                list.remove(integer);
            }
        }

        System.out.println(list);
    }

    @Test
    public void mapTest() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "4");
        map.put(3, "7");
        map.put(4, "12");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() % 2 == 0) {
                map.remove(entry.getKey());
            }
        }
        System.out.println(map);
    }

    @Test
    public void filterTest() {
        List<Integer> list = Arrays.asList(4, 5, 29, 43, 35, 12, 46, 86);
        List<Integer> list1 = list.stream().filter((i) -> {
            if (i % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(list1);
    }

    @Test
    public void getTest() {
        AdminFlightService service = new AdminFlightServiceImpl();
        Flight flight = service.getFlightById(1L);
        System.out.println(flight);
    }

    @Test
    public void queryTest() throws ParseException {
        AdminFlightService service = new AdminFlightServiceImpl();
        FlightParam param = new FlightParam();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.setTakeoff(sdf.parse("2020-08-27 00:00:00"));
        List<Flight> list = service.batchFlight(param);
        System.out.println(list);
    }

    @Test
    public void sortTest() {
        AdminFlightService service = new AdminFlightServiceImpl();
        List<Flight> list = service.sort();
        System.out.println(list);
    }

}
