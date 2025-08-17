package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterBoolean implements QueryParameter<Boolean> {
    private Boolean value;

    public QueryParameterBoolean(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setBoolean(parameterIndex, value.booleanValue());
    }
}
