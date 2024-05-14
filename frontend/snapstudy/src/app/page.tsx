"use client";
import React, { useState, useEffect } from "react";
import FlashcardList from "./FlashcardList";
import { FlashcardProps } from "./Flashcard";

const Page: React.FC = () => {
  const [flashcards, setFlashcards] = useState<FlashcardProps[]>([]);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchFlashcards = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/flashcards");
        console.log(response);

        if (!response.ok) {
          throw new Error("Network response was not ok.");
        }
        const data = await response.json();
        console.log(data);

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

  if (isLoading) return <p>Loading flashcards...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <FlashcardList flashcards={flashcards} />
    </main>
  );
};

export default Page;
