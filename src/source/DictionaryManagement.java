package source;

import java.io.*;
import java.util.Scanner;


class DictionaryManagement {
    static Dictionary dict = new Dictionary();
    static void insertFromCommandline(){
        Scanner scan = new Scanner(System.in);
        dict.size = scan.nextInt();

        for(int i=0; i<dict.size; i++){
            Word word = new Word();
            System.out.print("English Words: ");
            String eng = scan.next();
            word.setWord_target(eng);

            scan.nextLine();

            System.out.print("Explanation: ");
            String vie = scan.nextLine();
            word.setWord_explain(vie);

            dict.words.add(word);
        }
    }
    public static void insertFromFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Thu\\IdeaProjects\\Dictionary_TP\\dictionaries.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext()) {
            String eng = scan.next();
            String vie = scan.nextLine();
            Word word = new Word();
            word.setWord_target(eng);
            word.setWord_explain(vie);
            dict.size++;
            dict.words.add(word);
        }
    }
    static void dictionaryLookup(){

    }
}
