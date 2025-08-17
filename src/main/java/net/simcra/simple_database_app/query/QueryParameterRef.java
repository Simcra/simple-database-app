package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterRef implements QueryParameter<Ref> {
    private Ref value;

    public QueryParameterRef(Ref value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Ref getValue() {
        return value;
    }

    @Override
    public void setValue(Ref value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setRef(parameterIndex, value);
    }
}
