```java
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) {
            return true;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] orders = order.toCharArray();
        for(int i = 0; i < orders.length; i++) {
            map.put(orders[i], i);
        }
        
        for(int i = 0; i < words.length-1; i++) {
            if(!helper(words[i], words[i+1], map)) {
                return false;
            }
        }
        return true;
    }
    
    boolean helper(String word0, String word1, HashMap<Character, Integer> map) {
        int j = 0;
        while(j < word0.length() && j < word1.length()) {
            if(word0.charAt(j) != word1.charAt(j)) {
                if(map.get(word0.charAt(j)) < map.get(word1.charAt(j))) {
                    return true;
                } else {
                    return false;
                }
            }
            j++;
        }
            
        if(word0.length() > word1.length()) {
            return false;
        }
        return true;
    }
}
```