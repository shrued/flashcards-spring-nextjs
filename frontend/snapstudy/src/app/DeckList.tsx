"use client";
import React from "react";
import Deck, { DeckProps } from "./Deck";

interface DeckListProps {
  decks: DeckProps[];
}

const DeckList: React.FC<DeckListProps> = ({ decks }) => {
  return (
    <div className="deck-list">
      {decks.map((deck) => (
        <Deck key={deck.id} {...deck} />
      ))}
    </div>
  );
};

export default DeckList;
