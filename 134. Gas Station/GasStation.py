class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        if sum(gas)<sum(cost):
            return -1
        startIndex=0
        diff=0
        length=len(cost)
        for i in range(length):
            if gas[i]+diff<cost[i]:
                diff=0
                startIndex=i+1
            else:
                diff+=gas[i]-cost[i]
        return startIndex