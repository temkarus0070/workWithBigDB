package com.example.workWithBigDB.database.Entities.Addons;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PGPointType implements UserType,Serializable {
    @Override
    public int[] sqlTypes() {
        return new int[]
                {
                        Types.VARCHAR
                };
    }

    public PGPointType(){

    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<PGpoint> returnedClass() {
        return PGpoint.class;
    }

    @Override
    public boolean equals(Object obj, Object obj1) {
        return true;
    }

    @Override
    public int hashCode(Object obj) {
        return obj.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException, SQLException {
        if (names.length == 1) {
            if (resultSet.wasNull() || resultSet.getObject(names[0]) == null) {
                return null;
            } else {
                return new PGpoint(resultSet.getObject(names[0]).toString());
            }
        }
        return null;
    }


    @Override
    public void nullSafeSet(PreparedStatement statement, Object value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (value == null) {
            statement.setNull(index, Types.OTHER);
        } else {
            statement.setObject(index, value, Types.OTHER);
        }
    }

    @Override
    public Object deepCopy(Object obj) {
        return obj;
    }

    @Override
    public boolean isMutable() {
        return Boolean.FALSE;
    }

    @Override
    public Serializable disassemble(Object obj) {
        return (Serializable) obj;
    }

    @Override
    public Object assemble(Serializable serializable, Object obj) {
        return serializable;
    }

    @Override
    public Object replace(Object obj, Object obj1, Object obj2) {
        return obj;
    }

}