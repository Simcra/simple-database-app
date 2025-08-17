package net.simcra.simple_database_app.query;

import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterNClob implements QueryParameter<NClob> {
    private NClob value;

    public QueryParameterNClob(NClob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public NClob getValue() {
        return value;
    }

    @Override
    public void setValue(NClob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setNClob(parameterIndex, value);
    }
}
