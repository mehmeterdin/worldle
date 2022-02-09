package com.example.worldle;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Word> trWords = getAllList("kelimeler.txt");
        List<Word> engWords = getAllList("kelimelerEng.txt");
        char [] ignoreLettersArray = {'T', 'B', 'M', 'E', 'Ş', 'F'};
        List<FindedWordWithoutLocation> findWordAnyLocation = Stream
                .of(new FindedWordWithoutLocation('A', Stream.of(2).collect(Collectors.toList())),
                        new FindedWordWithoutLocation('R', Stream.of(4,3).collect(Collectors.toList())))
                .collect(Collectors.toList());

        findWordAnyLocation = new ArrayList<>();
        char first = 'E';
        char second = 0;
        char third = 'R';
        char fourth = 'A';
        char fifth = 0;


        writeConsol(findAndWriteWords(first, second, third, fourth, fifth, ignoreLettersArray, findWordAnyLocation, trWords));

    }

    private static List<String> findAndWriteWords(char first, char second, char third, char fourth, char fifth, char [] ignoreLetter, List<FindedWordWithoutLocation> findWordAnyLocation, List<Word> allWords){
        boolean didYouFindFifthLetter = false;
        boolean didYouFindFirstLetter = false;
        boolean didYouFindSecondLetter = false;
        boolean didYouFindThirdLetter = false;
        boolean didYouFindFourthLetter = false;
        boolean didYouFindIgnoredLetter = false;
        int count = 0;
        List<Boolean> findWordAnyLocationBooleanList = new ArrayList<>();

        List<String> temp = new ArrayList<>();
        for (Word word: allWords){
            if(first == 0 || first == word.getFirst()){
                didYouFindFirstLetter = true;
            }
            if(second == 0 || second == word.getSecond()){
                didYouFindSecondLetter = true;
            }
            if(third == 0 || third == word.getThird()){
                didYouFindThirdLetter = true;
            }
            if(fourth == 0 || fourth == word.getFourth()){
                didYouFindFourthLetter = true;
            }
            if(fifth == 0 || fifth == word.getFifth()){
                didYouFindFifthLetter = true;
            }

            ignoredLetterLoop:
            for (int i=0; i<=word.length()-1; i++) {
                for (int j=0; j <= ignoreLetter.length - 1; j++) {
                    if (word.getHimself().charAt(i) == ignoreLetter[j]) {
                        if(i == 0){
                            if(first != 0){
                                break;
                            }else{
                                didYouFindIgnoredLetter = true;
                                break ignoredLetterLoop;
                            }
                        }else if(i == 1){
                            if(second != 0){
                                break;
                            }else{
                                didYouFindIgnoredLetter = true;
                                break ignoredLetterLoop;
                            }
                        }else if(i == 2){
                            if(third != 0){
                                break;
                            }else{
                                didYouFindIgnoredLetter = true;
                                break ignoredLetterLoop;
                            }
                        }else if(i == 3){
                            if(fourth != 0){
                                break;
                            }else{
                                didYouFindIgnoredLetter = true;
                                break ignoredLetterLoop;
                            }
                        }else if(i == 4){
                            if(fifth != 0){
                                break;
                            }else{
                                didYouFindIgnoredLetter = true;
                                break ignoredLetterLoop;
                            }
                        }

                    }
                }
            }

            int a = 0;
            for(int i = 0; i<=findWordAnyLocation.size() - 1; i++){
                for (int j=0; j <= word.length() - 1; j++) {
                    if (word.getHimself().charAt(j) == findWordAnyLocation.get(i).getWord()) {
                        if(j == 0 ){
                            if(first != 0 || findWordAnyLocation.get(i).getIndex().contains(j)){
                                break;
                            }else{
                                a = 1;
                                findWordAnyLocationBooleanList.add(true);
                            }
                        }else if(j == 1){
                            if(second != 0 || findWordAnyLocation.get(i).getIndex().contains(j)){
                                break;
                            }else{
                                a = 1;
                                findWordAnyLocationBooleanList.add(true);
                            }
                        }else if(j == 2){
                            if(third != 0 || findWordAnyLocation.get(i).getIndex().contains(j)){
                                break;
                            }else{
                                a = 1;
                                findWordAnyLocationBooleanList.add(true);
                            }
                        }else if(j == 3){
                            if(fourth != 0 || findWordAnyLocation.get(i).getIndex().contains(j)){
                                break;
                            }else{
                                a = 1;
                                findWordAnyLocationBooleanList.add(true);
                            }
                        }else if(j == 4){
                            if(fifth != 0 || findWordAnyLocation.get(i).getIndex().contains(j)){
                                break;
                            }else{
                                a = 1;
                                findWordAnyLocationBooleanList.add(true);
                            }
                        }

                    }
                }
                if(a != 1)
                    findWordAnyLocationBooleanList.add(false);
                a = 0;
            }


            if(didYouFindFirstLetter && didYouFindSecondLetter && didYouFindThirdLetter && didYouFindFourthLetter && didYouFindFifthLetter && !didYouFindIgnoredLetter)
                if(!findWordAnyLocationBooleanList.contains(false))
                    temp.add(word.getHimself());


            didYouFindFifthLetter = didYouFindFirstLetter = didYouFindSecondLetter = didYouFindThirdLetter = didYouFindFourthLetter = didYouFindIgnoredLetter = false;
            findWordAnyLocationBooleanList = new ArrayList<>();

        }

        return temp;
    }
    private static void writeConsol(List<String> list){
        if(!list.isEmpty()){
            Random random = new Random();
            list.forEach(System.out::println);
            System.out.println("Total options : " + list.size());
            System.out.println("The Word I Chose For You : " + list.get(random.nextInt(list.size())));
        }

    }
    private static List<Word> getAllList(String path) {
        List<Word> temp = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                temp.add(new Word(myReader.nextLine()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

}
