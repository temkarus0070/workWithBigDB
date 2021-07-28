package com.example.workWithBigDB.resources;

import com.example.workWithBigDB.database.Entities.Ticket;
import com.example.workWithBigDB.services.TicketService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ticket")
public class TicketResource {

    @Inject
    TicketService ticketService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public String load(@QueryParam("minIndex")int minIndex){
        List<Ticket> ticketList=ticketService.get(minIndex);
        return ticketListToJson(ticketList).toString();
    }

    private JsonArray ticketListToJson(List<Ticket> ticketList){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        for(Ticket ticket:ticketList){
            jsonArrayBuilder.add(ticketToJson(ticket));
        }
        return jsonArrayBuilder.build();
    }

    private JsonObject ticketToJson(Ticket ticket){
        return Json.createObjectBuilder().add("ticket_no",ticket.getTicket_no())
                .add("passenger_id",ticket.getPassenger_id())
                .add("passenger_name",ticket.getPassenger_name())
                .add("contact_data",ticket.getContact_data())
                .build();
    }
}
