package com.example.workWithBigDB.resources;

import com.example.workWithBigDB.database.Entities.Airport;
import com.example.workWithBigDB.services.AirportService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/airport")
public class AirportResource {
    @Inject
    AirportService airportService;




    @GET
    @Path(value = "/get/{minIndex}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("minIndex") int minIndex){
        List<Airport> airportList=airportService.get(minIndex);
        return listAirportToJsonArray(airportList).toString();
    }

    @GET
    @Path(value = "/getAirport/{airport_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAirport(@PathParam(value = "airport_code")String airport_code){
        Airport airport=airportService.find(airport_code);
        return airportToJson(airport).toString();
    }

    public JsonObject airportToJson(Airport airport){
        JsonObject jsonObject= Json.createObjectBuilder()
                .add("airport_code",airport.getAirport_code())
                .add("airport_name",airport.getAirport_name())
                .add("city",airport.getCity())
                .add("coordinates",Json.createObjectBuilder()
                        .add("latitude",airport.getCoordinates().getLatitude())
                        .add("longitude",airport.getCoordinates().getLongitude())
                    )
                .add("timezone",airport.getTimezone())
                        .build();
                return jsonObject;
    }


    public JsonArray listAirportToJsonArray(List<Airport> airportList){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        for(Airport airport:airportList){
            jsonArrayBuilder.add(airportToJson(airport));
        }
        return jsonArrayBuilder.build();
    }


}