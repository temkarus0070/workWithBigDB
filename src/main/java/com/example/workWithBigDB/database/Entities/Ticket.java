package com.example.workWithBigDB.database.Entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ticket_no;


    @ManyToOne()
    @JoinColumn(name = "book_ref")
    private Booking booking;


    @OneToMany(mappedBy = "ticket",fetch=FetchType.EAGER)
    private List<TicketFlight> ticketFlights;

    private String passenger_id;

    private String passenger_name;

    private String contact_data;

    public Ticket(){

    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(String passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getContact_data() {
        return contact_data;
    }

    public void setContact_data(String contact_data) {
        this.contact_data = contact_data;
    }


}
