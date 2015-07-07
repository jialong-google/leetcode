class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,bool> hm;
        int small=nums.front();
        int big=nums.front();
        int max=0;
        for(vector<int>::iterator i=nums.begin();i<nums.end();i++)
            hm.insert(pair<int,bool>(*i,true));
        
        for(vector<int>::iterator i=nums.begin();i<nums.end();i++){
            int right=*i+1;
            int left=*i-1;
            if(hm[*i]){
                while(hm[right]){
                    hm[right]=false;
                    right++;
                }
                while(hm[left]){
                    hm[left]=false;
                    left--;
                }
                if(right-left-1>max)
                    max=right-left-1;
            }
        }
        return max;
    }
};
