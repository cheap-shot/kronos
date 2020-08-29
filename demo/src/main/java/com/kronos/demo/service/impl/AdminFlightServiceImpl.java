package com.kronos.demo.service.impl;

import com.kronos.demo.model.Flight;
import com.kronos.demo.param.FlightParam;
import com.kronos.demo.service.AdminFlightService;
import com.kronos.demo.service.BillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminFlightServiceImpl implements AdminFlightService {
    /**
     * 暂时用来存放航班信息，之后放在数据库
     */
    private List<Flight> flights;

    @Override
    public boolean add(Flight flight) {
        long id = flight.getId();
        if (this.getFlightById(id) != null) {
            return false;
        }
        flights.add(flight);
        return true;
    }

    @Override
    public boolean update(Flight flight) {
        long id = flight.getId();
        Flight src = this.getFlightById(id);
        if (src == null) {
            return false;
        }
        /*if (flight.getTakeoff() != null) {
            src.setTakeoff(flight.getTakeoff());
        }
        if (flight.getArrive() != null) {
            src.setArrive(flight.getArrive());
        }*/
        // 复制对象的属性
        BeanUtils.copyProperties(flight, src);
        return true;
    }

    @Override
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

    @Override
    public Flight getFlightById(long id) {
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public List<Flight> batchFlight(FlightParam param) {
        return flights.stream().filter((flight) -> {
            // TODO: 2020/8/29 增加其他查询条件
            return (param.getFlightId() == null || flight.getFlightId().equals(param.getFlightId())) &&
                    (param.getTakeoff() == null || (flight.getTakeoff().getTime() > param.getTakeoff().getTime())) &&
                    (param.getArrive() == null || flight.getArrive().getTime() < param.getArrive().getTime());
        }).collect(Collectors.toList());
    }

    @Override
    public List<Flight> sort() {
        return flights.stream().sorted((f1, f2) -> {
                return (int) (f1.getTakeoff().getTime() - f2.getTakeoff().getTime());
            }).collect(Collectors.toList());
        /*return flights.stream().sorted((f1, f2) -> {
            return (int) (f1.getTakeoff().getTime() - f2.getTakeoff().getTime());
        }).collect(Collectors.toList());*/
    }

    public AdminFlightServiceImpl() {
        init();
    }

    private void init() {
        flights = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Flight flight = new Flight();
            flight.setId(1L);
            flight.setTakeoff(sdf.parse("2020-08-27 10:00:00"));
            flight.setArrive(sdf.parse("2020-08-27 14:00:00"));
            flight.setFlightId("ABC-123");
            flight.setGmtCreated(new Date());
            flight.setGmtModified(new Date());
            Flight flight1 = new Flight();
            flight1.setId(1L);
            flight1.setTakeoff(sdf.parse("2020-08-28 22:00:00"));
            flight1.setArrive(sdf.parse("2020-08-29 2:00:00"));
            flight1.setFlightId("XYZ-987");
            flight1.setGmtCreated(new Date());
            flight1.setGmtModified(new Date());
            Flight flight2 = new Flight();
            flight2.setId(3L);
            flight2.setTakeoff(sdf.parse("2020-06-18 22:00:00"));
            flight2.setArrive(sdf.parse("2020-06-19 2:00:00"));
            flight2.setFlightId("JKL-000");
            flight2.setGmtCreated(new Date());
            flight2.setGmtModified(new Date());

            flights.add(flight);
            flights.add(flight1);
            flights.add(flight2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
