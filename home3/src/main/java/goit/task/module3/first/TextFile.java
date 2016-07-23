package goit.task.module3.first;

public class TextFile extends File {
    private int numberOfLines;
    public TextFile(String name) {
        super(name);
        super.setSize(25);
        numberOfLines = 25;
    }
    void nextPage(){}
    void prevPage(){}
}
