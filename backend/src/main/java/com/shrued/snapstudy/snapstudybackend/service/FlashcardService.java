package com.shrued.snapstudy.snapstudybackend.service;

import com.shrued.snapstudy.snapstudybackend.exception.ResourceNotFoundException;
import com.shrued.snapstudy.snapstudybackend.model.Flashcard;
import com.shrued.snapstudy.snapstudybackend.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    @Autowired
    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.findAll();
    }

    public Flashcard getFlashcardById(String id) {
        return flashcardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flashcard not found with id " + id));
    }

    public Flashcard createFlashcard(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    public Flashcard updateFlashcard(String id, Flashcard flashcardDetails) {
        Flashcard flashcard = flashcardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flashcard not found with id " + id));

        flashcard.setUserId(flashcardDetails.getUserId());
        flashcard.setDeckId(flashcardDetails.getDeckId());
        flashcard.setFront(flashcardDetails.getFront());
        flashcard.setBack(flashcardDetails.getBack());

        return flashcardRepository.save(flashcard);
    }

    public void deleteFlashcard(String id) {
        flashcardRepository.deleteById(id);
    }
}
