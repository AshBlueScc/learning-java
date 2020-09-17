package 企鹅精选练习50题;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author chengzhen
 * @date 2020/9/17
 * @time 2:26 PM
 */
public class Q146LRU缓存机制 {

    private LinkedList<Integer> keyList;    //用LinkedList存key，越靠近last权重越高
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int max;
    private int index = 0;

    public Q146LRU缓存机制(int capacity) {
        keyList = new LinkedList();
        max = capacity - 1;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        //1.key存在缓存里面，被重新赋值，权重调到最大
        if(keyList.contains(key)) {
            keyList.remove(Integer.valueOf(key));
            keyList.addLast(key);
            map.put(key, value);
            return;
        }
        //2。key不在缓存里面，且此时缓存已满
        if(index > max){
            //删除缓存的第一个
            map.remove(keyList.getFirst());
            keyList.removeFirst();

        }
        keyList.addLast(key);
        map.put(key,value);
        index++;
    }

    public static void main(String[] args) {
        Q146LRU缓存机制 cache = new Q146LRU缓存机制(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Integer i = cache.get(1);       // 返回  1
        System.out.println(i);
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        Integer j = cache.get(2);       // 返回 -1 (未找到)
        System.out.println(j);
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        Integer k = cache.get(1);       // 返回 -1 (未找到)
        System.out.println(j);
        Integer l = cache.get(3);       // 返回  3
        System.out.println(l);
        Integer m = cache.get(4);       // 返回  4
        System.out.println(m);

    }

}
