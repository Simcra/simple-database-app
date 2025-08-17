package net.simcra.simple_database_app.query;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterArray implements QueryParameter<Array> {
    private Array value;

    public QueryParameterArray(Array value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Array getValue() {
        return value;
    }

    @Override
    public void setValue(Array value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setArray(parameterIndex, value);
    }
}
