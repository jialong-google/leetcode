class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack_of_num=[]
        listofoperator=['+','-','/','*']
        i=0
        while(i<len(tokens)):
            if not tokens[i] in listofoperator:
                stack_of_num.append(int(tokens[i]))
            elif tokens[i]== '+':
                op2=stack_of_num.pop()
                op1=stack_of_num.pop()
                stack_of_num.append(op2+op1)
            elif tokens[i]== '*':
                op2=stack_of_num.pop()
                op1=stack_of_num.pop()
                stack_of_num.append(op1*op2)
            elif tokens[i]== '/':#be care of here!!!!!!!!!!!!!
                op2=stack_of_num.pop()
                op1=stack_of_num.pop()
                if op2*op1>0:
                    stack_of_num.append(op1/op2)
                else:
                    stack_of_num.append(-(-op1/op2))
            elif tokens[i]== '-':
                op2=stack_of_num.pop()
                op1=stack_of_num.pop()
                stack_of_num.append(op1-op2)
            i+=1
        if stack_of_num:
            return stack_of_num[-1]
        else:
            return 0