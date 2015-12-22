class Solution {
private:
    vector<int> res;
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        unordered_map<string,int> w;
        int wl=words[0].length();
        int sl=s.length();
        int ex=words.size();
        for(int i=0;i<ex;i++)
            w[words[i]]++;
        for(int i=0; i<wl; i++){//grid.
            int count=ex;
            unordered_map<string,int> r;
            int index=i;
            for(int k=i; k<sl; k+=wl)
            {
                string current=s.substr(k,wl);
                if(w.count(current)){//find it.
                    r[current]++;
                    count--;
                    //tricky!
                    while(r[current]>w[current]){//no--- not this one.
                        string st=s.substr(index,wl);
                        r[st]--;
                        index+=wl;
                        count++;
                    }
                    if(count==0){
                        res.push_back(index);
                        //back trace.
                        r[s.substr(index,wl)]--;
                        index+=wl;
                        count++;
                    }
                }
                else{//did not find it.
                    index=k+wl;
                    count=ex;
                    r.clear();
                }
                
            }
        }
        return res;
    }
};