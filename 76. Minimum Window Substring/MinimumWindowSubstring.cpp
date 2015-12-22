class Solution {
public:
    string minWindow(string s, string t) {
        //basically s is the longer one, t is the shorter one.
        int sl=s.length();
        int tl=t.length();
        if(sl<tl)   return "";
        
        int require[128]={0};
        bool isrequired[128]={false};
        
        for(int i=0;i<tl;i++){
            require[t[i]]++;
            isrequired[t[i]]=true;
        }
        int i=0;
        int j=0;
        int minl=sl+1;
        int mini=i;
        int counter=tl;//to be matched.
        while(i<sl && j<=sl){
            if(counter && j<sl){//something to be matched. actually we need to judge j<sl
                require[s[j]]--;
                if(require[s[j]]>=0 && isrequired[s[j]])
                    counter--;
                j++;//j stands for the NEXT right side window.
            }
            else{//nothing to be matched.
                //judge if has smaller size.
                if(minl> j-i && counter==0){
                    minl=j-i;
                    mini=i;
                }
                require[s[i]]++;
                if(require[s[i]]>0 && isrequired[s[i]])//found the inital letter is still needed.
                    counter++;
                i++;
            }
        }
        if(minl==sl+1)  return "";
        return s.substr(mini,minl);
    }
};