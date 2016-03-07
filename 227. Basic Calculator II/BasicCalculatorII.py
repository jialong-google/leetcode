class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        ops=[]
        nums=[]
        s=s.replace(" ","")
        num=""
        for i in s:
            if i.isdigit():
                num+=i
            else:
                nums.append(int(num))
                num=""
                ops.append(i)
        if len(num)>0:
            nums.append(int(num))
        i=0
        while( i <len(ops)):
            if ops[i]=="*":
                nums[i]=nums[i]*nums[i+1]
                ops.pop(i)
                nums.pop(i+1)
            elif ops[i]=="/":
                nums[i]=nums[i]/nums[i+1]
                ops.pop(i)
                nums.pop(i+1)
            else:
                i=i+1
        i=0
        while( i <len(ops)):
            if ops[i]=="+":
                nums[i]=nums[i]+nums[i+1]
                ops.pop(i)
                nums.pop(i+1)
            elif ops[i]=="-":
                nums[i]=nums[i]-nums[i+1]
                ops.pop(i)
                nums.pop(i+1)
        return nums[0]