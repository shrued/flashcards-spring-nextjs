package com.shrued.snapstudy.snapstudybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flashcards")
public class Flashcard {

    @Id
    private String id;

    private String userId;
    private String deckId;
    private String front;
    private String back;

    // No-args constructor
    public Flashcard() {
    }

    // All-args constructor
    public Flashcard(String id, String userId, String deckId, String front, String back) {
        this.id = id;
        this.userId = userId;
        this.deckId = deckId;
        this.front = front;
        this.back = back;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    // Optional: toString, equals, and hashCode methods for debugging and testing
}
