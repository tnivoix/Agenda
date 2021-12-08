package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    List<Event> eventList;

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     * @throws java.lang.Exception
     */
    public void addEvent(Event e) throws Exception {
        if (e.getTitle() == null || e.getStart() == null || e.getDuration() == null) {
            throw new Exception("Erreur dans la création de l'évènement");
        } else {
            eventList.add(e);
        }
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> events = new ArrayList<>();
        for (Event e : events) {
            if (e.isInDay(day)) {
                events.add(e);
            }
        }
        return events;
    }
}
