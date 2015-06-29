class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def twoSum(self, nums, target):
        index={}
        result=[]
        j=-1
        count=0
        for i in nums:
            if i> target:
                pass
            j=target-i
            if index.has_key(j):
                result.append(index[j])
                result.append(count+1)
                break
            else:
                index[i]= count +1
            count=count+1
        result.sort()
        return result
