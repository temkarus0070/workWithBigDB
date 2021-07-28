package com.example.workWithBigDB.database.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String book_ref;

    private Date book_date;

    private long total_amount;

    @OneToMany(mappedBy = "booking")
    private List<Ticket> tickets;

public Booking(){

}
    public Date getBook_date() {
        return book_date;
    }

    public String getBook_ref() {
        return book_ref;
    }

    public long getTotal_amount() {
        return total_amount;
    }

    public void setBook_date(Date book_date) {
        this.book_date = book_date;
    }

    public void setBook_ref(String book_ref) {
        this.book_ref = book_ref;
    }

    public void setTotal_amount(long total_amount) {
        this.total_amount = total_amount;
    }
}
