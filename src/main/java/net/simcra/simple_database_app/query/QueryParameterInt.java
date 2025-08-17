package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterInt implements QueryParameter<Integer> {
    private Integer value;

    public QueryParameterInt(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setInt(parameterIndex, value.intValue());
    }
}
