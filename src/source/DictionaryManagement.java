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
        File file = new File("C:\\Users\\Administrator.SCX1JKX2YEHIZ1G\\IdeaProjects\\Dictionary\\dictionaries.txt");
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
    public static void dictionaryLookup(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Choose a word to look up: ");
        System.out.println("(press -enough to stop)");
        do {
            String wordToLookUp = scan.nextLine();
            boolean found = false;
            if (wordToLookUp.equals("-enough")) break;
            for (int i=0 ; i<dict.size ; i++){
                if (dict.words.get(i).getWord_target().equals(wordToLookUp)){
                    System.out.println(dict.words.get(i).getWord_target() + " ===== " + dict.words.get(i).getWord_explain());
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Can not find your word");
        } while (true);
    }
    public static void deleteWord(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Choose a word to delete: ");
        System.out.println("(press -enough to stop)");
        do {
            String wordToDelete = scan.nextLine();
            boolean found = false;
            if (wordToDelete.equals("-enough")) break;
            for (int i=0; i<dict.size; i++){
                if (dict.words.get(i).getWord_target().equals(wordToDelete)){
                    dict.words.remove(i);
                    dict.size--;
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Can not find your word");
             else System.out.println("Your word has been deleted from the dictionary");
        } while (true);
    }
    public static void Search(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Type part of a word to search: ");
        System.out.println("(press -enough to stop)");
        do {
            String wordToSearch = scan.nextLine();
            if (wordToSearch.equals("-enough")) break;
            int length = wordToSearch.length();
            boolean found = false;
            for (int i=0 ; i<dict.size ;i++){
                if (length <= dict.words.get(i).getWord_target().length()){
                    if (dict.words.get(i).getWord_target().substring(0,length).equals(wordToSearch)){
                        System.out.println(dict.words.get(i).getWord_target());
                        found = true;
                    }
                }
            }
            if (!found) System.out.println("Can not find any word");
        } while (true);
    }
}