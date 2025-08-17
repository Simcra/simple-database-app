package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterDouble implements QueryParameter<Double> {
    private Double value;

    public QueryParameterDouble(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setDouble(parameterIndex, value.doubleValue());
    }
}
