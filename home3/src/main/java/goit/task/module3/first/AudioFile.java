package goit.task.module3.first;


public class AudioFile extends File {
    private String id3Tag;

    AudioFile( String name) {
        super(name);
        super.size = 100;
        id3Tag = "";
    }

    void ffw(){}
    void rev(){}
    void rec(){}

}
