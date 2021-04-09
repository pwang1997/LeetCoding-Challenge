```java
class Solution {
    public int minOperations(int n) {
        int sum = 0;
        int rounds = n / 2;
        while(rounds > 0) {
            sum += (n-rounds*2+1);
            rounds--;
        }
        return sum;
    }
}
```