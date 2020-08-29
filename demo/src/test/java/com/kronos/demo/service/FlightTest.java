package com.kronos.demo.service;

import com.kronos.demo.service.impl.FlightServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightTest {
    @Test
    public void removeTest() {
        FlightService service = new FlightServiceImpl();
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

}
