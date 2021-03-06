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

    public static void showAllWords(){
        System.out.println("No\t|English\t|Vietnamese");
        for(int i=0; i<dict.size; i++){
            System.out.printf("%d\t|%s\t\t|%s\n", i, dict.words.get(i).getWord_target(), dict.words.get(i).getWord_explain());
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


    public static void addWord(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Choose a word to add: ");
        System.out.println("(press -enough to stop)");
        do {
            String wordToAdd = scan.nextLine();
            if (wordToAdd.equals("-enough")) break;
            System.out.println("Define that word: ");
            String meaning = scan.nextLine();
            Word word = new Word();
            word.setWord_target(wordToAdd);
            word.setWord_explain(meaning);
            dict.size++;
            dict.words.add(word);
            System.out.println("Your word has been added ");
            System.out.println("Choose a word to add: ");
        } while (true);
    }


    public static void replaceWord(){
        Scanner scan = new Scanner (System.in);
        System.out.println("Choose a word to replace: ");
        System.out.println("(press -enough to stop)");
        do {
            String wordToReplace = scan.nextLine();
            if (wordToReplace.equals("-enough")) break;
            System.out.println("Redifine that word:");
            String meaning = scan.nextLine();
            boolean found = false;
            for (int i=0 ; i<dict.size ; i++){
                if (dict.words.get(i).getWord_target().equals(wordToReplace)){
                    dict.words.get(i).setWord_explain(meaning);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Can not find your word");
             else System.out.println("Word has been redefined");
            System.out.println("Choose a word to replace: ");
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


    public void dictionaryExportToFile() throws IOException {
        BufferedWriter bw = null;
        FileWriter fileW = null;
        String fileName = "C:\\Users\\Administrator.SCX1JKX2YEHIZ1G\\IdeaProjects\\Dictionary_TP\\dictionaries.txt";

        fileW = new FileWriter(fileName);
        bw = new BufferedWriter(fileW);
        for(int i=0; i<dict.size; i++){
            Word tempW = dict.words.get(i);
            bw.write(tempW.getWord_target() + "\t" + tempW.getWord_explain());
            bw.newLine();
        }
    }

    public static void openMenu() {
        System.out.println("Welcome to dictionary!");
        System.out.println("Type -show to see the current dictionary ");
        System.out.println("Type -add to add words to dictionary");
        System.out.println("Type -redef to redefine words in dictionary");
        System.out.println("Type -del to delete words in dictionary");
        System.out.println("Type -look to look up words in dictionary");
        System.out.println("Type -search to search multiple English words in dictionary");
        System.out.println("Type -close to close the dictionary");
        Scanner scan = new Scanner(System.in);
        boolean close = false;
        do {
            String choice = scan.nextLine();
            switch (choice) {
                case "-show":
                    showAllWords();
                    break;
                case "-add":
                    addWord();
                    break;
                case "-redef":
                    replaceWord();
                    break;
                case "-del":
                    deleteWord();
                    break;
                case "-look":
                    dictionaryLookup();
                    break;
                case "-search":
                    Search();
                    break;
                case "-close":
                    close = true;
                    break;
                default:
                    System.out.println("Your command doesn't exist");
            }
        } while (!close);
    }
}