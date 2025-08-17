package net.simcra.simple_database_app.query.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterFloat implements QueryParameter<Float> {
    private Float value;

    public QueryParameterFloat(Float value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public void setValue(Float value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setFloat(parameterIndex, value.floatValue());
    }
}
