package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.Objects;

public final class QueryParameterSQLXML implements QueryParameter<SQLXML> {
    private SQLXML value;

    public QueryParameterSQLXML(SQLXML value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public SQLXML getValue() {
        return value;
    }

    @Override
    public void setValue(SQLXML value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setSQLXML(parameterIndex, value);
    }
}
