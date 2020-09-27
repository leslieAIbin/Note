package Collection;

import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class DuplicateAndOrderTest {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("444");
        linkedList.add("333");
        linkedList.add("111");
        System.out.println(linkedList);


        /**
         * 不重复
         */
        TreeSet treeSet = new TreeSet();
        treeSet.add("111");
        treeSet.add("333");
        treeSet.add("222");
        treeSet.add("111");
        System.out.println(treeSet);

        System.out.println(1>>>16);
    }
}