package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterByte implements QueryParameter<Byte> {
    private Byte value;

    public QueryParameterByte(Byte value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Byte getValue() {
        return value;
    }

    @Override
    public void setValue(Byte value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setByte(parameterIndex, value.byteValue());
    }
}
