package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    private ChronoUnit frequency;

    private List<LocalDate> exceptions = new ArrayList<>();

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency = frequency;
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        exceptions.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;
    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        LocalDate tmp = aDay;
        int nb = 0;
        while (tmp.isAfter(getStart().toLocalDate())) {
            if (tmp.minus(1, getFrequency()).isAfter(getStart().toLocalDate().minusDays(1))) {
                tmp = tmp.minus(1, getFrequency());
            } else {
                break;
            }
        }
        return super.isInDay(tmp) && !exceptions.contains(aDay);
        /*
        switch (frequency) {
            case DAYS:
                return aDay.isAfter(getStart().toLocalDate().minusDays(1)) && !exceptions.contains(aDay);
            case WEEKS:
                long debutW = getStart().toLocalDate().getDayOfWeek().getValue();
                long finW = getStart().plus(getDuration()).toLocalDate().getDayOfWeek().getValue();
                return aDay.getDayOfWeek().getValue() >= debutW && aDay.getDayOfWeek().getValue() <= finW && !exceptions.contains(aDay);
            case MONTHS:
                int debutY = getStart().toLocalDate().getDayOfMonth();
                int finY = getStart().plus(getDuration()).toLocalDate().getDayOfMonth();
                return aDay.getDayOfMonth() >= debutY && aDay.getDayOfMonth() <= finY && !exceptions.contains(aDay);
            default:
                return false;

        }
         */
    }

}
