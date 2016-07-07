package goit.task.module3.first;


public class File {
    Directory directory;

    private String name;
    public int size;


    File(String name) {
        this.name = name;
        this.size = 0;  //новый File пустой
    }

    public void openFile() {}
    public void closeFile() {}
}
