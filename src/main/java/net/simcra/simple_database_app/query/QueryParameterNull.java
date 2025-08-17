package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class QueryParameterNull implements QueryParameter<Integer> {
    private static final List<Integer> VALID_VALUES = Collections.unmodifiableList(Arrays.asList(
            java.sql.Types.ARRAY, java.sql.Types.BIGINT, java.sql.Types.BINARY, java.sql.Types.BIT,
            java.sql.Types.BLOB, java.sql.Types.BOOLEAN, java.sql.Types.CHAR, java.sql.Types.CLOB,
            java.sql.Types.DATALINK, java.sql.Types.DISTINCT, java.sql.Types.DOUBLE,
            java.sql.Types.FLOAT, java.sql.Types.INTEGER, java.sql.Types.JAVA_OBJECT,
            java.sql.Types.LONGNVARCHAR, java.sql.Types.LONGVARBINARY, java.sql.Types.LONGVARCHAR,
            java.sql.Types.NCHAR, java.sql.Types.CLOB, java.sql.Types.NULL, java.sql.Types.NUMERIC,
            java.sql.Types.NVARCHAR, java.sql.Types.OTHER, java.sql.Types.REAL, java.sql.Types.REF,
            java.sql.Types.REF_CURSOR, java.sql.Types.ROWID, java.sql.Types.SMALLINT,
            java.sql.Types.SQLXML, java.sql.Types.STRUCT, java.sql.Types.TIME,
            java.sql.Types.TIME_WITH_TIMEZONE, java.sql.Types.TIMESTAMP,
            java.sql.Types.TIMESTAMP_WITH_TIMEZONE, java.sql.Types.TINYINT,
            java.sql.Types.VARBINARY, java.sql.Types.VARCHAR));

    private Integer value;

    public QueryParameterNull(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (!VALID_VALUES.contains(value)) {
            throw new IllegalArgumentException(String.format("%s is not a valid value", value));
        }
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        Objects.requireNonNull(value);
        if (!VALID_VALUES.contains(value)) {
            throw new IllegalArgumentException(String.format("%s is not a valid value", value));
        }
        this.value = value;
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        preparedStatement.setNull(parameterIndex, value.intValue());
    }
}
