package no.nav.domain.pensjon.regler.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility for localized parsing and formatting of dates.
 *
 * @version $Id: DateUtil.java 2833 2006-03-10 09:50:32Z skb2930 $
 */
public final class DateUtil {

    /**
     * Representation of ETERNITY (31.12.9999).
     */
    private static final Date ETERNITY = java.sql.Date.valueOf("9999-12-31");
    /* Legal date formats. */
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final DateCreator dateCreator = new DefaultDateCreator();

    /**
     * Should not be instantiated.
     */
    private DateUtil() {
    }

    /**
     * Format a Date into a localized String (dd.MM.yyyy).
     *
     * @param input the date to format.
     * @return the formatted date or empty string for null input or "eternity" (31.12.9999).
     * @see #ETERNITY
     */
    public static String format(final Date input) {
        if (null == input || ETERNITY.equals(input)) {
            return "";
        } else {
            return createDateFormat(DATE_FORMAT).format(input);
        }
    }

    /**
     * Checks if one date is before another date. Only uses the date portion of the input, not taking the time portion in
     * account.
     *
     * @param firstDate the first date.
     * @param secondDate the second date to check against.
     * @return true if first date is before the second date, false otherwise.
     */
    public static boolean isBeforeDay(final Date firstDate, final Date secondDate) {
        if (null == firstDate) {
            return false;
        }

        final Calendar firstCalendar = createEmptyTimeFieldsCalendar(firstDate);
        // Use today's date if second date is empty
        final Calendar secondCalendar = createEmptyTimeFieldsCalendar(null == secondDate ? dateCreator.createDate()
                : secondDate);

        return firstCalendar.getTime().before(secondCalendar.getTime());
    }

    /**
     * Method that checks if a date is between two other dates.
     *
     * @param compDate date that is being checked.
     * @param fomDate FOM-date.
     * @param tomDate TOM-date.
     * @return boolean if date is in period.
     */
    public static boolean isDateInPeriod(final Date compDate, final Date fomDate, final Date tomDate) {
        if (null == fomDate || null == compDate) {
            return false;
        }

        boolean tomOK = false;

        if (null != tomDate) {
            if (isBeforeDay(compDate, tomDate) || isSameDay(compDate, tomDate)) {
                tomOK = true;
            }
        } else {
            tomOK = true;
        }

        return (isBeforeDay(fomDate, compDate) || isSameDay(compDate, fomDate)) && tomOK;
    }

    /**
     * Creates a non-lenient <code>DateFormat</code> from the specified date format.
     *
     * @param dateFormat the date format the created <code>DateForm</code> will have.
     * @return a non-lenient <code>DateFormat</code> with the specified date format.
     */
    public static DateFormat createDateFormat(final String dateFormat) {
        SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance();
        format.setLenient(false);
        format.applyLocalizedPattern(dateFormat);

        return format;
    }

    /**
     * Creates a non-lenient calendar with empty time fields.
     *
     * @param date the <code>Date</code> to create a calendar from.
     * @return a non-lenient calendar with empty time fields.
     * @see #createCalendar(Date)
     */
    private static Calendar createEmptyTimeFieldsCalendar(final Date date) {
        final Calendar calendar = createCalendar(date);
        clearTimeFields(calendar);

        return calendar;
    }

    /**
     * Creates a non-lenient calendar.
     *
     * @param date the <code>Date</code> to create a calendar from.
     * @return a non-lenient calendar.
     * @see #createCalendar(Date)
     */
    private static Calendar createCalendar(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);

        return calendar;
    }

    /**
     * Clears the time fields of a calendar.
     *
     * @param calendar the calendar to clear the time fields of.
     */
    private static void clearTimeFields(final Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * Check whether a closed date range intersects another closed date range. Will throw a NullPointerException if any of the
     * passed parameters are null. To check for intersection there are several cases to be covered:
     * <pre>
     *       |-------|          (the first period, called period 1)
     *       |-------|		  0 same period is an intersection
     * |---|                  1 no intersection with period 1
     *                 |----| 2 no intersection with period 1
     *  |-------|             3 intersection, it ends before period 1 ends
     *             |------|   4 intersection, it starts before period 1 ends
     * |----------------|     5 intersection, starts before and ends after period 1
     * |-----|				  6 Special case, ends when period 1 starts (by milliseconds)
     *               |------| 7 Special case, begins when period 1 ends  (by milliseconds)
     * </pre>
     *
     * @param o1Start The start date of the first period
     * @param o1End The end date of the first period
     * @param o2Start The start date of the second period
     * @param o2End The end date of the second period
     * @param considerContactAsIntersection If cases 6 and 7 should be regarded as a intersection, set this flag to true.
     * @return true if the periods do intersect by , false otherwise
     */
    public static boolean intersectsByMilliseconds(Date o1Start, Date o1End, Date o2Start, Date o2End,
            boolean considerContactAsIntersection) {

        boolean isPoint = o1Start.equals(o1End) || o2Start.equals(o2End);

        // get the max of starts
        long start = Math.max(o1Start.getTime(), o2Start.getTime());
        // get the min of ends
        long end = Math.min(o1End.getTime(), o2End.getTime());

        if (considerContactAsIntersection || isPoint) {
            return (start <= end);
        } else {
            return (start < end);
        }
    }

    /**
     * Removes the values for HOUR_OF_DAY, MINUTES, SECONDS and MILLISECONDS before the compare such
     * that same day is regarded as intersection if <code>considerContactByDayAsIntersection</code> is true.
     *
     * @param o1Start The start date of the first period
     * @param o1End The end date of the first period
     * @param o2Start The start date of the second period
     * @param o2End The end date of the second period
     * @param considerContactByDayAsIntersection If cases 6 and 7 should be regarded as a intersection, set this flag to true.
     * @return true if the periods do intersect by day, false otherwise
     */
    public static boolean intersects(Date o1Start, Date o1End, Date o2Start, Date o2End,
            boolean considerContactByDayAsIntersection) {
        Date o1StartDay = createDayCalendar(o1Start).getTime();
        Date o1EndDay = createDayCalendar(o1End).getTime();
        Date o2StartDay = createDayCalendar(o2Start).getTime();
        Date o2EndDay = createDayCalendar(o2End).getTime();

        return intersectsByMilliseconds(o1StartDay, o1EndDay, o2StartDay, o2EndDay, considerContactByDayAsIntersection);
    }

    /**
     * {@see DateUtil.intersects} Removes the values for HOUR_OF_DAY, MINUTES, SECONDS and MILLISECONDS before the compare such
     * that same day is regarded as intersection if <code>considerContactByDayAsIntersection</code> is true. The endings of
     * the respective periods can be NULL, if so these will be set to infinity.
     *
     * @param o1Start The start date of the first period
     * @param o1End The end date of the first period; can be null, if so is interpreted as infinity
     * @param o2Start The start date of the second period
     * @param o2End The end date of the second period; can be null, if so is interpreted as infinity
     * @param considerContactByDayAsIntersection If cases 6 and 7 should be regarded as a intersection, set this flag to true.
     * @return true if the periods do intersect by day, false otherwise
     */
    public static boolean intersectsWithPossiblyOpenEndings(Date o1Start, Date o1End, Date o2Start, Date o2End,
            boolean considerContactByDayAsIntersection) {

        return intersects(o1Start, (o1End == null) ? new Date(Long.MAX_VALUE) : o1End, o2Start,
                (o2End == null) ? new Date(Long.MAX_VALUE) : o2End, considerContactByDayAsIntersection);
    }

    /**
     * Small utility method for comparing two dates down to the granularity of days. Returns true if the dates are the same day.
     * Hours, minutes, seconds and milliseconds are not regarded.
     *
     * @param thisDate the first date to check.
     * @param thatDate the second date to check.
     * @return true if the dates point to the same day.
     */
    public static boolean isSameDay(Date thisDate, Date thatDate) {
        if (thisDate == null && thatDate == null) {
            return false;
        }

        Calendar thisCal = createDayCalendar(thisDate);
        Calendar thatCal = createDayCalendar(thatDate);

        return thisCal.equals(thatCal);
    }

    /**
     * Creates a new Date object set to the date fields given by the input parameters. All other date fields are cleared.
     *
     * @param year the year to set
     * @param month the month to set
     * @param day the day of the month to set
     * @return a new Date object
     */
    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month, day);
        return cal.getTime();
    }

    /**
     * Create a calendar with only year, month and day set. If the passed date is null, it gets assigned to year zero,
     * reasonably far from our time.
     *
     * @param date the date do convert
     * @return the calendar of date granularity
     */
    private static Calendar createDayCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date == null) {
            cal.clear();
            cal.set(0, Calendar.JANUARY, 0, 0, 0, 0);
        } else {
            cal.setTime(date);
            clearTimeFields(cal);
        }
        return cal;
    }

    /**
     * Interface for creating dates.
     *
     */
    public interface DateCreator {

        /**
         * Creates a new Date.
         *
         * @return a new date
         */
        Date createDate();
    }

    /**
     * Utility for creating dates.
     *
     */
    public static class DefaultDateCreator implements DateCreator {

        /**
         * Returns a new date.
         *
         * @return the new date
         */
        public Date createDate() {
            return new Date();
        }
    }
}
