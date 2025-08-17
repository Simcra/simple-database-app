package net.simcra.simple_database_app.query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Objects;

public final class QueryParameterTime implements QueryParameter<Time> {
    private Time value;
    private Calendar calendar;

    public QueryParameterTime(Time value) {
        this.value = Objects.requireNonNull(value);
        this.calendar = null;
    }

    @Override
    public Time getValue() {
        return value;
    }

    @Override
    public void setValue(Time value) {
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
            preparedStatement.setTime(parameterIndex, value, calendar);
        } else {
            preparedStatement.setTime(parameterIndex, value);
        }
    }
}
