package com.example.worldle;

public class Word {
    String himself;
    char first;
    char second;
    char third;
    char fourth;
    char fifth;

    public Word(String himself) {
        this.himself = himself;
        this.first = himself.charAt(0);
        this.second = himself.charAt(1);
        this.third = himself.charAt(2);
        this.fourth = himself.charAt(3);
        this.fifth = himself.charAt(4);
    }

    public int length(){
        return himself.length();
    }

    public String getHimself() {
        return himself;
    }

    public void setHimself(String himself) {
        this.himself = himself;
    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    public char getThird() {
        return third;
    }

    public void setThird(char third) {
        this.third = third;
    }

    public char getFourth() {
        return fourth;
    }

    public void setFourth(char fourth) {
        this.fourth = fourth;
    }

    public char getFifth() {
        return fifth;
    }

    public void setFifth(char fifth) {
        this.fifth = fifth;
    }
}
