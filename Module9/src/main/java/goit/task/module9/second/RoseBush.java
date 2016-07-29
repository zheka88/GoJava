package goit.task.module9.second;

public class RoseBush extends Flower {
    private int valueToSmallBucket;    //количество бутонов в "букет бутонов" :)
    private int burgeonCount;          //количество бутонов в кусте
    public RoseBush(int burgeonCount) {
        this.burgeonCount = burgeonCount;
    }

    public RoseBush() {

    }

    void makeRoseBucket(){}
    public int getValueToSmallBucket() {
        return valueToSmallBucket;
    }
    public void setValueToSmallBucket(int valueToSmallBucket) {
        this.valueToSmallBucket = valueToSmallBucket;
    }
    public int getBurgeonCount() {
        return burgeonCount;
    }
    public void setBurgeonCount(int burgeonCount) {
        this.burgeonCount = burgeonCount;
    }
}
