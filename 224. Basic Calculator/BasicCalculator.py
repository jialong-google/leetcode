class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack=[1]
        sign=1
        nums=[]
        num=0
        for i in s+"+":
            if i.isdigit():
                num=num*10+int(i)
            elif i=='+':
                num=num*sign*stack[-1]
                nums.append(num)
                num=0
                sign=1
            elif i=='-':
                num=num*sign*stack[-1]
                nums.append(num)
                num=0
                sign=-1
            elif i=='(':
                stack.append(sign*stack[-1])
                sign=1#restore it.!!!!
            elif i==')':
                num=num*sign*stack[-1]
                nums.append(num)
                num=0
                stack.pop()
                sign=stack[-1]
        print nums
        if len(nums)>1:
            return reduce(lambda a,b:a+b,nums)
        else:
            return nums[0]