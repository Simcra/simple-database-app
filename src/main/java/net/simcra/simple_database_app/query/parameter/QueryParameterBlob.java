package net.simcra.simple_database_app.query.parameter;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterBlob implements QueryParameter<Blob> {
    private Blob value;

    public QueryParameterBlob(Blob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Blob getValue() {
        return value;
    }

    @Override
    public void setValue(Blob value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setBlob(parameterIndex, value);
    }
}
