package Collection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
public class SafeHashMapDemo {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> safeMap = Collections.synchronizedMap(map);
        ConcurrentHashMap map2 = new ConcurrentHashMap();
        safeMap.put(1, 123);
        safeMap.put(2, 231);
        System.out.println(safeMap.get(2));
    }
    
}