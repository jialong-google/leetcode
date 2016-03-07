class Solution {
    int len;
public:
    int findKthLargest(vector<int>& nums, int k) {
        if(nums.empty())
            return 0;
        len=nums.size();
        
        return selectK(nums,0,len-1,k);
    }
    int selectK(vector<int>& nums,int prev,int rear,int k)
    {
        if(prev==rear)
            return nums[prev];
        int pivot=rear;
        int bigpart=rear-1;
        int smallpart=prev;
        while(smallpart<bigpart)
        {
            while(nums[bigpart]>nums[pivot]&& bigpart>smallpart)
                bigpart--;
            while(nums[smallpart]<=nums[pivot]&& bigpart>smallpart)
                smallpart++;
            swap(nums[smallpart],nums[bigpart]);
        }
        if(nums[smallpart]>nums[pivot])
        {
            swap(nums[smallpart],nums[pivot]);
            pivot=smallpart;
        }
        else{
            smallpart=smallpart+1;//不会溢出。因为smallpart==bigpart and bigpart<rear. 
            swap(nums[smallpart],nums[pivot]);//这一步是保证pivot
            pivot=smallpart;
        }
        if(k-1==rear-pivot)
        {
            return nums[pivot];
        }
        else if(k-1<rear-pivot)
        {
            return selectK(nums,pivot+1,rear,k);
        }
        else if(k-1>rear-pivot)
        {
            return selectK(nums,prev,pivot-1,k-rear+pivot-1);
        }
        
    }
};