package goit.task.module3.first;


public class TextFile extends File {
    private int numberOfLines;

    TextFile(String name) {
        super(name);
        super.size = 25;
        numberOfLines = 25;
    }

    void nextPage(){}
    void prevPage(){}
}
