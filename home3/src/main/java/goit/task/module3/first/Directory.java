package goit.task.module3.first;


import java.util.List;

public class Directory {
    List<File> files;
    String name;
    String path;

    Directory(String name) {
        this.name = name;
        this.path = path + name;
    }

    private void sortBy() {}
}
