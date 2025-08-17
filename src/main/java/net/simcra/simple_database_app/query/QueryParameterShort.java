package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterShort implements QueryParameter<Short> {
    private Short value;

    public QueryParameterShort(Short value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Short getValue() {
        return value;
    }

    @Override
    public void setValue(Short value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setShort(parameterIndex, value.shortValue());
    }
}
