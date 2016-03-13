class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        xor=reduce(lambda x,y:x^y,nums)
        spur=xor & -xor
        a=b=0
        for i in nums:
            if i & spur:
                a=a^i
            else:
                b=b^i
        return [a,b]