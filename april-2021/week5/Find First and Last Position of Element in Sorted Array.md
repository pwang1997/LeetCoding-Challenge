```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int targetIndex = binarySearch(nums, target);
        
        if(targetIndex == -1) {
            return new int[]{-1, -1};
        } 
        
        int l = 0, r = targetIndex;
        
        int first = 0;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                if(mid == l || nums[mid-1] != target) {
                    first = mid; 
                    break;
                } else {
                    r = mid - 1;
                }
            }
        }
        
        int last = 0;
        l = targetIndex;
        r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                if(mid == r || nums[mid+1] != target) {
                    last = mid; 
                    break;
                } else {
                    l = mid + 1;
                }
            }
        }
        
        
        return new int[]{first, last};
    }
    
    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        
        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid -1;
        }
        
        return -1;
    }
}
```