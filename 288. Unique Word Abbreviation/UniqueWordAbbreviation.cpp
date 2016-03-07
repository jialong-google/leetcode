class ValidWordAbbr {
    unordered_map<string,string> dict;
public:
    ValidWordAbbr(vector<string> &dictionary) {
        if (dictionary.empty())
            return;
        int len=dictionary.size();
        for(int i=0;i<len;i++)
        {
            string s;
            int len2=dictionary[i].length();
            if(len2>2)
                s=dictionary[i][0]+to_string(len2-2)+dictionary[i][len2-1];
            else
                s=dictionary[i][0]+dictionary[i][len2-1];
            ////!!!pay special attention to this part!
            if(dict.find(s)==dict.end())
                dict[s]=dictionary[i];
            else if(dict[s]!=dictionary[i])
                dict[s]="memeda";
        }
    }

    bool isUnique(string word) {
        string s;
        int len2=word.length();
        if(len2>2)
            s=word[0]+to_string(len2-2)+word[len2-1];
        else
            s=word[0]+word[len2-1];
        ////!!!!pay special attention to this part!
        if(dict.find(s)!=dict.end())
            if(dict[s]=="memeda" || dict[s]!=word)
                return false;
            else
                return true;
        else
            return true;
    }
};


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa(dictionary);
// vwa.isUnique("hello");
// vwa.isUnique("anotherWord");