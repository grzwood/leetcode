package SearchInRotated;

public class Solution {

  public static void main(String[] args) {
    int[] array = new int[]{3,1,2,2,2};
    int target = 1;
    var result = search(array, target);
  }

  public static boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    if (nums.length == 0) {
      return false;
    }
    while (left <= right) {
      if (nums[left] == target || nums[right] == target) {
        return true;
      }
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] == nums[left] && nums[mid] == nums[right]) { // 特殊情况
        left++;
        right--;
        continue;
      }
      if (nums[mid] <= nums[right]) { // 右侧是顺序的
        if (target > nums[mid] && target < nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else { // 左侧是顺序的
        if (target > nums[left] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return false;
  }
}
