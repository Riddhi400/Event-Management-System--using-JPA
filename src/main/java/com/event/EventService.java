package com.event;

import jakarta.persistence.*;
import java.util.List;

public class EventService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventPU");

    public void createEvent(String name, String date, String location) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Event(name, date, location));
        em.getTransaction().commit();
        em.close();
    }
    
    public void assignUserToEvent(int userId, int eventId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, userId);
        Event event = em.find(Event.class, eventId);

        if (user != null && event != null) {
            user.getEvents().add(event);
            event.getUser().add(user);
            em.persist(user); // Save the relationship
            System.out.println("User assigned to event.");
        } else {
            System.out.println("User or Event not found.");
        }

        tx.commit();
        em.close();
    }

    public void registerUser(String name, String email) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new User(name, email));
        em.getTransaction().commit();
        em.close();
    }

    public void viewEvents() {
        EntityManager em = emf.createEntityManager();
        List<Event> events = em.createQuery("FROM Event", Event.class).getResultList();
        for (Event e : events) {
            System.out.printf("ID: %d | %s | %s | %s\n", e.getId(), e.getName(), e.getDate(), e.getLocation());
        }
        em.close();
    }
    
    public void viewAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("FROM User", User.class).getResultList();
        for (User u : users) {
            System.out.println("ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
        }
        em.close();
    }

    public void close() {
        emf.close();
    }
}
