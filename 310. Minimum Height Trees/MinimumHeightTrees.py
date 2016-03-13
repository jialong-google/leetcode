class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        
        map=collections.defaultdict(list)
        for [node1,node2] in edges:
            map[node1].append(node2)
            map[node2].append(node1)
        ver=map.keys()
        leaf=[ i for i in ver if len(map[i])==1]
        while len(ver)>2:
            new_leaf=[]
            for leafnode in leaf:
                otherside=map[leafnode][0]
                map[otherside].remove(leafnode)
                if len(map[otherside])==1:
                    new_leaf.append(otherside)
                del map[leafnode]
                ver.remove(leafnode)
            leaf=new_leaf
        return ver if not n==1 else [0]