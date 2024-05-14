"use client";
import React, { useState, useEffect } from "react";
import FlashcardList from "./FlashcardList";
import { FlashcardProps } from "./Flashcard";
import DeckList from "./DeckList";
import { DeckProps } from "./Deck";

const Page: React.FC = () => {
  const [flashcards, setFlashcards] = useState<FlashcardProps[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchFlashcards = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/flashcards");

        if (!response.ok) {
          throw new Error("Network response was not ok.");
        }
        const data = await response.json();

        setFlashcards(data);
      } catch (error) {
        console.error("Error fetching flashcards:", error);
        setError("Failed to fetch flashcards. Please try again later.");
      } finally {
        setIsLoading(false);
      }
    };

    fetchFlashcards();
  }, []);

  const decks: DeckProps[] = [];

  flashcards.forEach((flashcard) => {
    const existingDeck = decks.find((deck) => deck.id === flashcard.deckId);

    if (existingDeck) {
      existingDeck.flashcards.push(flashcard);
    } else {
      decks.push({
        id: flashcard.deckId,
        title: `Deck ${flashcard.deckId}`,
        flashcards: [flashcard],
      });
    }
  });

  if (isLoading) return <p>Loading flashcards...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <DeckList decks={Object.values(decks)} />
    </main>
  );
};

export default Page;
