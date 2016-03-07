class Solution(object):
    
    def add(self,num1,num2):
        """
        :type num1:list
        :type num2:list
        :rtype:list
        """
        resolution=[]
        carry=0
        while num1 and num2:
            inum1=int(num1.pop())
            inum2=int(num2.pop())
            r=inum1+inum2+carry
            resolution.append(r%10)
            carry=r/10
            if (not num1) and carry:
                num1.append(carry)
                carry=0
            elif (not num2) and carry:
                num2.append(carry)
                carry=0
        if num1:
            resolution+=num1[::-1]
        if num2:
            resolution+=num2[::-1]
        return resolution[::-1]
        
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        carry=0
        midresult_before_add=[]
        i=0
        if num1=='0' or num2=='0':
            return '0'
        while num1 and num2:
            num=int(num1[-1])
            num1=num1[:-1]
            carry=0
            medium=[]
            for index in range(len(num2))[::-1]:
                r=(int(num2[index])*num+carry)
                medium.append(r%10)
                carry=r/10
            if carry:
                medium.append(carry)
            medium=medium[::-1]+[0 for w in range(i)]
            i+=1
            midresult_before_add.append(medium)
        if len(midresult_before_add)>=2:
            m=reduce(self.add,midresult_before_add)
        else:
            m=midresult_before_add[0]
        reso=''
        for i in m:
            reso+=str(i)
        return reso
            
        