```java
class Solution {
    HashMap<Character, String> map = null;
    List<String> list = null;
    
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return list;
        }
        
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
            
        
        letterCombinations("", 0, digits);
        
        return list;
    }
    
    void letterCombinations(String current, int index, String digits) {
        if(current.length() == digits.length()) {
            list.add(current);
            return;
        }
        
        while(index < digits.length()) {
            for(Character c : map.get(digits.charAt(index)).toCharArray()) {
                letterCombinations(current+c, index+1, digits);
            }
            index++;
        }
    }
}
```