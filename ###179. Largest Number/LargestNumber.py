class Solution(object):
    def largestNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        def compare(a,b):
            if a+b>b+a:
                return -1
            else:
                return 1
        res=sorted([str(i) for i in nums],cmp=compare)
        return reduce(lambda x,y:x+y,res).lstrip('0') or '0'
        