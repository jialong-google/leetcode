class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic=collections.defaultdict(int)
        for i in nums:
            dic[i]+=1
        for (key,value) in dic.items():
            if not value==3:
                return key
        return -1
            
        