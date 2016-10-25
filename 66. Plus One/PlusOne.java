public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return new int[]{1};
        boolean carry = true;
        int i = digits.length - 1;
        for(; i >= 0; i--)
        {
            if(digits[i] == 9 && carry == true)
            {
                digits[i] = 0;
            }
            else
            {
                digits[i] ++;
                carry = false;
                break;
            }
        }
        if(carry == false)
            return digits;
        else
        {
            int[] res = new int[digits.length +1];
            res[0] = 1;
            for(int j = 0; j < digits.length; j++)
            {
                res[j + 1] = digits[j];
            }
            return res;
        }
    }
}