class Solution {
public:
    int jump(vector<int>& nums) {
        int last_scope=0;
        int next_scope=0;
        int step=0;
        for(int i=0;i<nums.size();i++){
            if(i>last_scope)
            {
                last_scope=next_scope;
                step++;
            }
            if(i+nums[i]>next_scope){
                next_scope=i+nums[i];
            }
        }
        return step;
    }
};