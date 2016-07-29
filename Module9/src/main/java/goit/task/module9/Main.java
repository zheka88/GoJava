package goit.task.module9;

import goit.task.module9.Cesar;
import goit.task.module9.second.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<String>();
        collection.add(Aster.class.getSimpleName());
        collection.add(Chamomile.class.getSimpleName());
        collection.add(Flower.class.getSimpleName());
        collection.add(Rose.class.getSimpleName());
        collection.add(RoseBush.class.getSimpleName());
        collection.add(Tulip.class.getSimpleName());
        System.out.println(collection.toString());
        List<String> encodedCollection = new ArrayList<String>();

        for (String s : collection) {
            encodedCollection.add(Cesar.encode(s, 20));
        }
        System.out.println(encodedCollection.toString());
        List<String> decodedCollection = new ArrayList<String>();

        for (String s : encodedCollection) {
            decodedCollection.add(Cesar.decode(s, 20));
        }
        System.out.println(decodedCollection.toString());
    }
}

