package net.simcra.simple_database_app.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class Query {
    private List<QueryParameter<?>> queryParameters;
    private PreparedStatement preparedStatement;

    public Query(Connection connection, String sql, List<QueryParameter<?>> queryParameters)
            throws SQLException {
        this.preparedStatement = Objects.requireNonNull(connection).prepareStatement(sql);
        this.queryParameters = Objects.requireNonNull(queryParameters);
    }

    public List<QueryParameter<?>> getQueryParameters() {
        return this.queryParameters;
    }

    public void setQueryParameters(List<QueryParameter<?>> queryParameters) {
        this.queryParameters = Objects.requireNonNull(queryParameters);
    }

    public ResultSet executeQuery() throws SQLException {
        // Update all of the query parameters in the prepared statement
        for (int i = 0; i < queryParameters.size(); i++) {
            queryParameters.get(i).apply(preparedStatement, i + 1);
        }

        preparedStatement.setEscapeProcessing(true);
        return preparedStatement.executeQuery();
    }
}
