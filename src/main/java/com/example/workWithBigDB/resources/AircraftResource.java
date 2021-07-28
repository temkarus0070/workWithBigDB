package com.example.workWithBigDB.resources;

import com.example.workWithBigDB.database.Entities.Aircraft;
import com.example.workWithBigDB.database.Entities.Flight;
import com.example.workWithBigDB.services.AircraftService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("aircraft")
public class AircraftResource {

    @Inject
    AircraftService aircraftService;

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("minIndex")int minIndex){
        String str="";
        List<Aircraft> aircraftList=aircraftService.get(minIndex);

        return  aircraftListToJson(aircraftList).toString();
    }

    private JsonArray aircraftListToJson(List<Aircraft> aircraftList){
        JsonArrayBuilder jsonArrayBuilder= Json.createArrayBuilder();
        for(Aircraft aircraft:aircraftList){
                jsonArrayBuilder.add(aircraftToJson(aircraft));
        }
        return jsonArrayBuilder.build();
    }

    private JsonObject aircraftToJson(Aircraft aircraft){
        JsonObject jsonObject=Json.createObjectBuilder()
                .add("aircraft_code",aircraft.getAircraft_code())
                .add("model",aircraft.getModel())
                .add("range",aircraft.getRange())
                .build();
        return jsonObject;
    }
}
