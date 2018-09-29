package source;

class Word {
    private String word_target;
    private String word_explain;

    void setWord_target(String w_t){
        word_target = w_t;
    }
    void setWord_explain(String w_e){
        word_explain = w_e;
    }
    String getWord_target() {
        return word_target;
    }
    String getWord_explain() {
        return word_explain;
    }
}
