package source;

import java.io.FileNotFoundException;

import static source.DictionaryManagement.*;

public class DictionaryCommandLine {

    private static void showAllWords(){
        System.out.println("No\t|English\t|Vietnamese");
        for(int i=0; i<dict.size; i++){
            System.out.printf("%d\t|%s\t\t|%s\n", i, dict.words.get(i).getWord_target(), dict.words.get(i).getWord_explain());
        }
    }
    private static void dictionaryBasic(){
        insertFromCommandline();
        showAllWords();
    }
    private static void dictionaryAdvanced() throws FileNotFoundException {
        insertFromFile();
        showAllWords();
        deleteWord();
        showAllWords();
        dictionaryLookup();
        dictionarySearcher();
    }
    private static void dictionarySearcher(){
        Search();
    }
    public static void main(String[] args) throws FileNotFoundException {
        dictionaryAdvanced();
    }
}