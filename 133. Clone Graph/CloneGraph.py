# Definition for a undirected graph node
# class UndirectedGraphNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        self.visited={}
        def dfs(node):
            if node.label in self.visited:
                return self.visited[node.label]
            else:
                self.visited[node.label]=UndirectedGraphNode(node.label)
                copy_list=node.neighbors
                for i in copy_list:
                    self.visited[node.label].neighbors.append(dfs(i))
                return self.visited[node.label]
        if node:
            return dfs(node)
        else:
            return None
        
        