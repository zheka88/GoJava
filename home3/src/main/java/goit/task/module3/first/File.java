package goit.task.module3.first;

public class File {
    Directory directory;
    private String name;
    private int size;
    public File(String name) {
        this.name = name;
        this.size = 0;  //новый File пустой
    }
    public void openFile() {}
    public void closeFile() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
