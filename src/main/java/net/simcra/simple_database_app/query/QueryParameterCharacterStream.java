package net.simcra.simple_database_app.query;

import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterCharacterStream implements QueryParameter<Reader> {
    private Reader value;

    public QueryParameterCharacterStream(Reader value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Reader getValue() {
        return value;
    }

    @Override
    public void setValue(Reader value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setCharacterStream(parameterIndex, value);
    }
}
