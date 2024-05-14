"use client";
import React from "react";
import { FlashcardProps } from "./Flashcard";
import FlashcardList from "./FlashcardList";

export interface DeckProps {
  id: string;
  title: string;
  flashcards: FlashcardProps[];
}

const Deck: React.FC<DeckProps> = ({ id, title, flashcards }) => {
  return (
    <div className="deck">
      <h2>{title}</h2>
      <FlashcardList flashcards={flashcards} />
    </div>
  );
};

export default Deck;
