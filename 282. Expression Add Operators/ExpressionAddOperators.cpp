class Solution {
private:
    vector<string> res;
    int t;
public:
    vector<string> addOperators(string num, int target) {
        t=target;
        string out="";
        DC(num,out,0,0);
        return res;
    }
    
    void DC(string left, string output, long long current, long long prev){
        if(current==t && left.length()==0){
            res.push_back(output);
        }
        for(int i=1;i<=left.length();i++){
            string cur=left.substr(0,i);
            string remain=left.substr(i);
            long long curr=stoll(cur);
            
            if(cur.length()>1 && cur[0]=='0')
                return;
            
            if(output.length()==0)
            {
                DC(remain,cur,curr,curr);
            }
            else{
                //+
                DC(remain,output+"+"+cur,curr+current,curr);
                //-
                DC(remain,output+"-"+cur,current-curr,-curr);
                //*
                DC(remain,output+"*"+cur, (current-prev)+curr*prev, prev*curr);
            }
        }
        
    }
};