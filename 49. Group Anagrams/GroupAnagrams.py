class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ans_dic=collections.defaultdict(list)#{"":[]}
        for i in strs:
            char=str(sorted(i))
            ans_dic[char].append(i)
        return [sorted(i) for i in ans_dic.values()]
            