package net.simcra.simple_database_app.query.parameter;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterAsciiStream implements QueryParameter<InputStream> {
    private InputStream value;

    public QueryParameterAsciiStream(InputStream value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public InputStream getValue() {
        return value;
    }

    @Override
    public void setValue(InputStream value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setAsciiStream(parameterIndex, value);
    }
}
