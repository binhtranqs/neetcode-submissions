class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Tìm tốc độ tối đa cần thiết (phần tử lớn nhất trong mảng)
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int result = right;
        
        // Binary Search trên khoảng tốc độ [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                result = mid; // Ghi nhận kết quả khả thi
                right = mid - 1; // Thử tìm xem có tốc độ nào nhỏ hơn mà vẫn kịp không
            } else {
                left = mid + 1; // Tốc độ quá chậm, phải tăng tốc độ lên
            }
        }
        
        return result;
    }
    
    // Hàm Predicate kiểm tra xem với tốc độ k thì có ăn hết trong h giờ không
    private boolean canEatAll(int[] piles, int h, int k) {
        long totalHours = 0; // Dùng long để tránh tràn số khi cộng dồn
        
        for (int pile : piles) {
            // Tính số giờ cần cho nải này: công thức tương đương Math.ceil((double)pile / k)
            totalHours += (pile + k - 1) / k; 
            
            // Tối ưu: Nếu số giờ vượt quá h rồi thì không cần tính tiếp
            if (totalHours > h) {
                return false;
            }
        }
        
        return totalHours <= h;
    }
}