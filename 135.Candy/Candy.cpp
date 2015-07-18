class Solution {
public:
    int candy(vector<int>& ratings) {
        int collect=0;
        const int len=ratings.size();
        int result[len];
        for(int i=0;i<len;i++)
            result[i]=1;

        //正向扫
        if(len==1) return 1;
        for(int i=1;i<len;i++)
           if(ratings[i]>ratings[i-1])
               result[i]=result[i-1]+1;
        //反向扫
        for(int i=len-2;i>=0;i--)
            if(ratings[i]>ratings[i+1])
                result[i]=max(result[i],result[i+1]+1);
        
        for(int i=0;i<len;i++)
            collect+=result[i];
        return collect;
    }
};
