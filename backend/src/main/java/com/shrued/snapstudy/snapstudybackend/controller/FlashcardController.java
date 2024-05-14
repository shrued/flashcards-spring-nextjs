package com.shrued.snapstudy.snapstudybackend.controller;

import com.shrued.snapstudy.snapstudybackend.model.Flashcard;
import com.shrued.snapstudy.snapstudybackend.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards") 
public class FlashcardController {

    private final FlashcardService flashcardService;

    @Autowired
    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getAllFlashcards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getFlashcardById(@PathVariable String id) {
        Flashcard flashcard = flashcardService.getFlashcardById(id);
        return ResponseEntity.ok(flashcard);
    }

    @PostMapping
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
        Flashcard createdFlashcard = flashcardService.createFlashcard(flashcard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlashcard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable String id, @RequestBody Flashcard flashcardDetails) {
        Flashcard updatedFlashcard = flashcardService.updateFlashcard(id, flashcardDetails);
        return ResponseEntity.ok(updatedFlashcard); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashcard(@PathVariable String id) {
        flashcardService.deleteFlashcard(id);
        return ResponseEntity.noContent().build();
    }
}
