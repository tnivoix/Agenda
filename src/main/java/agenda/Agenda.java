package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    List<Event> eventList = new ArrayList<>();

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

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> events = new ArrayList<>();
        for (Event e : events) {
            if (e.getTitle().contains(title)) {
                events.add(e);
            }
        }
        return events;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        LocalDate dayStart = e.getStart().toLocalDate();
        LocalDate dayEnd = e.getStart().plus(e.getDuration()).toLocalDate();
        // faut pas qu'il soit tous les events compris entre début et fin, et aucun isInDay dans cette durée
        // tous les év. !isInDay, des jours de l'évent il faut finir avant le début et commencer après la fin de l'event
        if()
        }
    }
}
