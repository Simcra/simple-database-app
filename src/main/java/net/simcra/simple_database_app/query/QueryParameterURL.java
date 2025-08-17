package net.simcra.simple_database_app.query;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public final class QueryParameterURL implements QueryParameter<URL> {
    private URL value;

    public QueryParameterURL(URL value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public URL getValue() {
        return value;
    }

    @Override
    public void setValue(URL value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setURL(parameterIndex, value);
    }
}
