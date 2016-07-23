package goit.task.module3.first;

public class AudioFile extends File {
    private String id3Tag;
    public AudioFile( String name) {
        super(name);
        super.setSize(100);
        id3Tag = "song";
    }
    void ffw(){}
    void rev(){}
    void rec(){}
}
