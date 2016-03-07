class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegree=[0]*numCourses
        edgelist=[[]for i in range(numCourses)]#!!!!!!!!!!!!!!!
        zero=[]
        for [outpoint,inpoint] in prerequisites:
            indegree[inpoint]+=1
            edgelist[outpoint].append(inpoint)
        for index in range(len(indegree)):
            if indegree[index]==0:
                zero.append(index)
        while(zero):
            dealpoint=zero.pop()
            if edgelist[dealpoint]:
                for inpoint in edgelist[dealpoint]:
                    indegree[inpoint]-=1
                    if indegree[inpoint]==0:
                        zero.append(inpoint)
        for i in indegree:
            if not i==0:
                return False
        return True
        
        