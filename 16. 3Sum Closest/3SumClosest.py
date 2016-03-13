class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        current_best=9999
        current_diff=9999
        nums.sort()
        for i in range(len(nums)-2):
            left=i+1
            right=len(nums)-1
            while(left<right):
                sum=nums[i]+nums[left]+nums[right]
                diff=sum-target
                if diff==0:
                    return target
                else:
                    if abs(diff)<abs(current_diff):
                        current_diff=diff
                        current_best=sum
                    if sum>target:
                        right-=1
                    else:
                        left+=1
        return current_best