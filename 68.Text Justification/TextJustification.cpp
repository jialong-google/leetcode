class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string>:: iterator i;
        vector<string> result;
        int done_words=0;
        int deal_words=0;
        string y;
        int szofy=0;
        for(i=words.begin();i!=words.end();i++){
            int s=i->length();
            if(szofy+s<=maxWidth)//进入y
            {
                deal_words++;
                szofy+=(s+1);
            }
            else//将已经清理好的y 输入result 清空y 和szofy 更新done_words/deal_words. 再次进入y
            {
                //清理y
                int rem=maxWidth-szofy+1;
                //剩下的空格
                string kong;
                kong+=' ';
                for(int i=0;deal_words!=1 && i<rem/(deal_words-1);i++){
                    kong+=' ';
                }
                for(int i=done_words;i<done_words+(deal_words-1);i++){
                    y+=words[i];
                    y+=kong;
                    if(deal_words!=1 && rem%(deal_words-1)!=0){
                        y+=' ';
                        rem--;
                    }
                }
                y+=words[done_words+deal_words-1];
                if(deal_words==1)
                    for(int i=y.length();i<maxWidth;i++)
                        y+=' ';
                //输入result
                result.push_back(y);
                //清空y和szofy
                y.clear();
                //更新done deal
                done_words+=deal_words;
                deal_words=1;
                //再次进入y
                szofy=(s+1);
            }
        }
        //末行处理
        if(szofy!=0){
            for(int i=done_words;i<done_words+deal_words-1;i++){
                    y+=words[i];
                    y+=' ';
            }
            y+=words[done_words+deal_words-1];
            for(int i=y.length();i<maxWidth;i++)
                y+=' ';
            result.push_back(y);
        }
        return result;
    }
};