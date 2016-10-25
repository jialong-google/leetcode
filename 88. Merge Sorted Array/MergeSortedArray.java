public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 || nums1 == null || nums1.length == 0 || nums2 == null|| nums2.length ==0 )
        {
            return ;
        }
        int i = m - 1;
        int j = n - 1;
        int last = m + n - 1;
        while(j >= 0 && i >= 0)
        {
            if(nums1[i] < nums2[j])
            {
                nums1[last--] = nums2[j--]; 
            }
            else
            {
                nums1[last--] = nums1[i--];
            }
        }
        while(j >= 0)
        {
            nums1[last --] = nums2[j --];
        }
        while(i >= 0)
        {
            nums1[last --] = nums1[i --];
        }
    }
}