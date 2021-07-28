package com.example.workWithBigDB.database.Entities.Addons;


import org.postgresql.geometric.PGpoint;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.awt.*;
import java.awt.geom.Point2D;

@Converter(autoApply = true)
public class PointConverter implements AttributeConverter<LocationPoint, PGpoint> {

    @Override
    public PGpoint convertToDatabaseColumn(LocationPoint locationPoint) {
        return new PGpoint(locationPoint.getLatitude(), locationPoint.getLongitude());
    }

    @Override
    public LocationPoint convertToEntityAttribute(PGpoint pGpoint) {
        return new LocationPoint(pGpoint.x,pGpoint.y);
    }
}
