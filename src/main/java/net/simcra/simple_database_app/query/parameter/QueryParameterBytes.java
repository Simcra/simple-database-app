package net.simcra.simple_database_app.query.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterBytes implements QueryParameter<byte[]> {
    private byte[] value;

    public QueryParameterBytes(byte[] value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public byte[] getValue() {
        return value;
    }

    @Override
    public void setValue(byte[] value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setBytes(parameterIndex, value);
    }
}
