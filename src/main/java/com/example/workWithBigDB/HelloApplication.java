package com.example.workWithBigDB;




import com.example.workWithBigDB.filters.CORSFilter;
import com.example.workWithBigDB.resources.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes=new HashSet<>();
        classes.add(AirportResource.class);
        classes.add(AircraftResource.class);
        classes.add(CORSFilter.class);
        classes.add(TicketResource.class);
        return classes;
    }
}