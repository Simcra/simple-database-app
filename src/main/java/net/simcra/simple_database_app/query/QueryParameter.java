package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public sealed interface QueryParameter<T>
        permits QueryParameterArray, QueryParameterAsciiStream, QueryParameterBigDecimal, QueryParameterBinaryStream,
        QueryParameterBlob, QueryParameterBoolean, QueryParameterByte, QueryParameterBytes,
        QueryParameterCharacterStream, QueryParameterClob, QueryParameterDate, QueryParameterDouble,
        QueryParameterFloat, QueryParameterInt, QueryParameterLong, QueryParameterNCharacterStream, QueryParameterNClob,
        QueryParameterNString, QueryParameterNull, QueryParameterRef, QueryParameterRowId, QueryParameterShort,
        QueryParameterString, QueryParameterSQLXML, QueryParameterTime, QueryParameterTimestamp, QueryParameterURL {
    T getValue();

    void setValue(T value);

    void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException;
};
