package com.example.worldle;

import java.util.List;

public class FindedWordWithoutLocation {
    char word;
    List<Integer> index;

    public FindedWordWithoutLocation(char word, List<Integer> index) {
        this.word = word;
        this.index = index;
    }

    public char getWord() {
        return word;
    }

    public void setWord(char word) {
        this.word = word;
    }

    public List<Integer> getIndex() {
        return index;
    }

    public void setIndex(List<Integer> index) {
        this.index = index;
    }
}
