class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int i2=numbers.size()-1;
        int i1=0;
        vector <int> t;
        while(numbers[i2]+numbers[i1]!=target)
        {
            if(numbers[i2]+numbers[i1]>target)
            {
                i2--;
            }
            else
            {
                i1++;
            }
        }
        t.push_back(i1+1);
        t.push_back(i2+1);
        return t;
    }
};