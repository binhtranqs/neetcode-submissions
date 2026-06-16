class Solution {
    public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Nếu tìm thấy target, trả về index ngay
        if (nums[mid] == target) {
            return mid;
        }

        // BƯỚC 1: Kiểm tra xem nửa bên trái có được sắp xếp không
        if (nums[left] <= nums[mid]) {
            // BƯỚC 2: Kiểm tra xem target có nằm trong nửa trái này không
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1; // Thu hẹp sang trái
            } else {
                left = mid + 1;  // Nhảy sang phải
            }
        } 
        // Ngược lại, nửa bên phải chắc chắn được sắp xếp
        else {
            // Kiểm tra xem target có nằm trong nửa phải này không
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;  // Thu hẹp sang phải
            } else {
                right = mid - 1; // Nhảy sang trái
            }
        }
    }

    // Nếu không tìm thấy target trong mảng
    return -1;
}
}
