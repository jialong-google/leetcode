class Solution(object):
    def findItinerary(self, tickets):
        """
        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        if not tickets:
            return []
        fromAtoB={}
        for f,t in sorted(tickets):
            if not f in fromAtoB:
                fromAtoB[str(f)]=[str(t)]
            else:
                fromAtoB[str(f)].append(str(t))
        for i in fromAtoB:
            fromAtoB[i].sort()
        route=[]
        def helper(frompoint):
            if not frompoint:
                return
            if frompoint not in fromAtoB:
                route.append(frompoint)
                return
            while fromAtoB[frompoint]:
                pointcanreach=fromAtoB[frompoint][0]
                del fromAtoB[frompoint][0]
                helper(pointcanreach)
            route.append(frompoint)
        helper('JFK')
        return route[::-1]