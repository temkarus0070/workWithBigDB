package com.example.workWithBigDB.database.Entities;


import com.example.workWithBigDB.database.Entities.Addons.Status;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flight_id;

    private String flight_no;

    private Date scheduled_departure;

    private Date scheduled_arrival;

    @ManyToOne()
    @JoinColumn(name = "departure_airport")
    private Airport departure_airport;

    @ManyToOne()
    @JoinColumn(name = "arrival_airport")
    private Airport arrival_airport;



    @Enumerated(EnumType.STRING)
    private Status status;



    private Date actual_departure;

    private Date actual_arrival;


    @OneToMany(mappedBy = "flight")
    private List<TicketFlight> ticketFlights;

    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public List<TicketFlight> getTicketFlights() {
        return ticketFlights;
    }

    public Flight(){

    }
    public void setTicketFlights(List<TicketFlight> ticketFlights) {
        this.ticketFlights = ticketFlights;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public Date getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(Date scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public Date getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(Date scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public Airport getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(Airport arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public void setDeparture_airport(Airport departure_airport) {
        this.departure_airport = departure_airport;
    }

    public Airport getDeparture_airport() {
        return departure_airport;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public Date getActual_departure() {
        return actual_departure;
    }

    public void setActual_departure(Date actual_departure) {
        this.actual_departure = actual_departure;
    }

    public Date getActual_arrival() {
        return actual_arrival;
    }

    public void setActual_arrival(Date actual_arrival) {
        this.actual_arrival = actual_arrival;
    }
}
