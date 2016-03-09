class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        tmp_dict={}
        nums.sort()
        ans=[]
        for p in range(len(nums)-1):
            for q in range(p+1,len(nums)):
                T=target-nums[p]-nums[q]
                if T not in tmp_dict:
                    tmp_dict[T]=[(p,q)]
                else:
                    tmp_dict[T].append((p,q))
        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                T=nums[i]+nums[j]
                if T in tmp_dict:
                    for (p,q) in tmp_dict[T]:
                        nn=[nums[p],nums[q],nums[i],nums[j]]
                        if i>q and (nn not in ans):
                            ans.append(nn)
        return ans