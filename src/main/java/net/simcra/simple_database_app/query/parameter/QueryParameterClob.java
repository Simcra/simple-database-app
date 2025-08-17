package net.simcra.simple_database_app.query.parameter;

import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterClob implements QueryParameter<Clob> {
    private Clob value;

    public QueryParameterClob(Clob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Clob getValue() {
        return value;
    }

    @Override
    public void setValue(Clob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setClob(parameterIndex, value);
    }
}
