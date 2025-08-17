package net.simcra.simple_database_app.query;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Objects;

public final class QueryParameterDate implements QueryParameter<Date> {
    private Date value;
    private Calendar calendar;

    public QueryParameterDate(Date value) {
        this.value = Objects.requireNonNull(value);
        this.calendar = null;
    }

    @Override
    public Date getValue() {
        return value;
    }

    @Override
    public void setValue(Date value) {
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
            preparedStatement.setDate(parameterIndex, value, calendar);
        } else {
            preparedStatement.setDate(parameterIndex, value);
        }
    }
}
