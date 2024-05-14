package com.shrued.snapstudy.snapstudybackend.repository;

import com.shrued.snapstudy.snapstudybackend.model.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlashcardRepository extends MongoRepository<Flashcard, String> {
}
