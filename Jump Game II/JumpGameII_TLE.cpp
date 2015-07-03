class Solution {
public:
    int farreach(vector<int>& nums, int index){
        //返回最远能到达index的nums下标。
        int i;
        for(i=0;i<index;i++){
            if(i+nums[i]>=index)
                break;
        }
        if(i==index)
        {
            return -1;//代表不能达到
        }
        return i;
    }
    int jump(vector<int>& nums) {
        int count=0;
        int i=nums.size()-1;
        //int i=farreach(nums,nums.size()-1);
        while(i!=0){
            i=farreach(nums,i);
            count++;
        }
        return count;
    }
};
