package net.simcra.simple_database_app.query;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterBinaryStream implements QueryParameter<InputStream> {
    private InputStream value;

    public QueryParameterBinaryStream(InputStream value) {
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
        preparedStatement.setBinaryStream(parameterIndex, value);
    }
}
