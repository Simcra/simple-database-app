package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

public final class QueryParameterTimestamp implements QueryParameter<Timestamp> {
    private Timestamp value;
    private Calendar calendar;

    public QueryParameterTimestamp(Timestamp value) {
        this.value = Objects.requireNonNull(value);
        this.calendar = null;
    }

    @Override
    public Timestamp getValue() {
        return value;
    }

    @Override
    public void setValue(Timestamp value) {
        this.value = Objects.requireNonNull(value);
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void apply(PreparedStatement preparedStatement, int parameterIndex) throws SQLException {
        if (calendar != null) {
            preparedStatement.setTimestamp(parameterIndex, value, calendar);
        } else {
            preparedStatement.setTimestamp(parameterIndex, value);
        }
    }
}
