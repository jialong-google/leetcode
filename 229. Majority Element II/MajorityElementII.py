class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        num1,num2=None,None
        index1,index2=0,0
        times1,times2=0,0
        for i in range(len(nums)):
            if nums[i]==num2:
                times2+=1
            elif nums[i]==num1:
                times1+=1
            elif num1==None:
                index1=i
                num1=nums[i]
                times1=1
            elif num2==None:
                index2=i
                num2=nums[i]
                times2=1
            else:
                times1-=1
                times2-=1
            if times1==0:
                num1=None
            if times2==0:
                num2=None
        ans=[]
        count1,count2=0,0
        for i in nums:
            if not num1==None and num1==i:
                count1+=1
            if not num2==None and num2==i:
                count2+=1
        if count1>len(nums)/3:
            ans.append(num1)
        if count2>len(nums)/3 and num2 not in ans:
            ans.append(num2)
        return ans