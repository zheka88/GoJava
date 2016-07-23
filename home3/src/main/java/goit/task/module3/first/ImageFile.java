package goit.task.module3.first;

public class ImageFile extends File {
    private String colorRange;
    public ImageFile(String name) {
        super(name);
        super.setSize(50);
        colorRange = "32bit";
    }
    void zoomIn(){}
    void zoomOut(){}
}
