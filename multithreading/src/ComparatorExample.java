import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<>() {
            public int compare(Integer n1, Integer n2) {
                if (n1 % 10 > n2 % 10) {
                    return 1;
                }
                return -1;
            }
        };

        List<Integer> list = new ArrayList<Integer>();
        list.add(71);
        list.add(34);
        list.add(93);
        list.add(22);
        Collections.sort(list, comparator);
        list.forEach(System.out::println);
        Map<Character,Integer> mapCount = new LinkedHashMap<>();
        for(Character c: mapCount.keySet()){
          int count= c-'a';
          mapCount.put(c,count);
        }
    }





}
