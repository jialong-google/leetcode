class Solution {
public:
    double findK(vector<int>& num1,int m,vector<int>& num2,int n,int k){
        if(m>n)
            return findK(num2,n,num1,m,k);
        if(m==0)
            return num2[k-1];
        if(k==1)
            return min(num1[0],num2[0]);
        int pa=min(m,k/2);
        int pb=k-pa;
        
        if(num1[pa-1]<num2[pb-1]){
            vector<int> sub(num1.begin()+pa,num1.end());
            return findK(sub,m-pa,num2,n,k-pa);
        }
        else if(num1[pa-1]==num2[pb-1])
            return num1[pa-1];
        else{
            vector<int> sub(num2.begin()+pb,num2.end());
            return findK(num1,m,sub,n-pb,k-pb);
        }
    }
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m=nums1.size();
        int n=nums2.size();
        if((m+n)%2==1)
            return findK(nums1,m,nums2,n,(m+n)/2+1);
        else
            return ((double)(findK(nums1,m,nums2,n,(m+n)/2+1)+findK(nums1,m,nums2,n,(m+n)/2)))/2;
    }
};
