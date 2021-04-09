```java
class Solution {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int a : A) {
            if(map.get(a) == null) {
                set.add(a);
                map.put(a, 1);
            } else {
                set.remove(a);
                map.put(a, map.get(a) + 1);
            }
        }

        Iterator<Integer> it = set.iterator();

        int largestNum = -1;
        while(it.hasNext()) {
            Integer next = it.next();
            if(next > largestNum) {
                largestNum = next;
            }
        }
        return largestNum;
    }
}
```