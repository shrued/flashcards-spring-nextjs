"use client";
import React from "react";

export interface FlashcardProps {
  id: string;
  front: string;
  back: string;
}

const Flashcard: React.FC<FlashcardProps> = ({ id, front, back }) => {
  const [showBack, setShowBack] = React.useState(false);

  const handleClick = () => {
    setShowBack(!showBack);
  };

  return (
    <div onClick={handleClick} className="flashcard">
      <div>{showBack ? back : front}</div>
    </div>
  );
};

export default Flashcard;
