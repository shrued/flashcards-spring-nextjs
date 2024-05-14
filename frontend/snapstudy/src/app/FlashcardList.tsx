"use client";
import React from "react";
import Flashcard, { FlashcardProps } from "./Flashcard";

interface FlashcardListProps {
  flashcards: FlashcardProps[];
}

const FlashcardList: React.FC<FlashcardListProps> = ({ flashcards }) => {
  return (
    <div>
      {flashcards.map((flashcard) => (
        <Flashcard key={flashcard.id} {...flashcard} />
      ))}
    </div>
  );
};

export default FlashcardList;
