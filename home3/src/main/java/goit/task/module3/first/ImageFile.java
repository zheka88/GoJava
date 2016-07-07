package goit.task.module3.first;


public class ImageFile extends File {
    private String colorRange;

    ImageFile(String name) {
        super(name);
        super.size = 50;
        colorRange = "32bit";
    }

    void zoomIn(){}
    void zoomOut(){}
}
