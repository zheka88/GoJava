package goit.task.module3.third;


abstract class Shop {
    public int cost;

    abstract void makeDemo();
    public int sellOut() {
        int cash = cost;
        return cash;
    }
}
