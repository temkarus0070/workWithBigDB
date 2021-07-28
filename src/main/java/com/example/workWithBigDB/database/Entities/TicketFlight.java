package com.example.workWithBigDB.database.Entities;




import com.example.workWithBigDB.database.Entities.IdEmbedable.TicketAndFlight;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_flights")
public class TicketFlight {

    @EmbeddedId
    private TicketAndFlight id;



    @ManyToOne()
    @JoinColumn(name = "ticket_no")
    private Ticket ticket;

    private String fare_conditions;



    private int amount;


    @ManyToOne()
            @JoinColumn(name = "flight_id")

    private Flight flight;


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }


public TicketFlight() {

}


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }



    public String getFare_conditions() {
        return fare_conditions;
    }

    public void setFare_conditions(String fare_conditions) {
        this.fare_conditions = fare_conditions;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TicketAndFlight getId() {
        return id;
    }

    public void setId(TicketAndFlight id) {
        this.id = id;
    }
}
