package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterRowId implements QueryParameter<RowId> {
    private RowId value;

    public QueryParameterRowId(RowId value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public RowId getValue() {
        return value;
    }

    @Override
    public void setValue(RowId value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setRowId(parameterIndex, value);
    }
}
