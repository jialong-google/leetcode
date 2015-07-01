class Solution {
public:
    bool canputhere(int current,int Q[]){//只需要判断现在这列的前面几列能不能攻击到自己就够了。
        for(int i=0; i< current; i++){
            if(abs(Q[current]-Q[i])==abs(current-i) || Q[current]==Q[i])
                return false;
        }
        return true;
    }
    void Queens(int n, int Max, int Q[], int &result){
        Q[n]++;
        while(!canputhere(n,Q) || Q[n]>=Max){//摆法不合法。
            if(Q[n]>=Max){//摆出棋盘
                if(n==0)//已经回溯到了第一个，结束程序。
                    return;
                else{//将当前这一个归到-1的位置上，然后回溯到前一个，接着往下摆。
                    Q[n]=-1;
                    return Queens(n-1,Max,Q,result);
                }
            }
            Q[n]++;//当前棋子进一格。
        }//从循环中出来代表当前棋子摆法合法且没有摆出棋盘外。
        if(n== Max-1)//摆好了最后一个棋子，就可以打印出来啦！
        {
            result++;
            //为了形成新的棋子摆法，回溯到上一个棋子去~
            Q[n]=-1;
            if(n==0)
                return;
            else
                Queens(n-1,Max,Q,result);//回溯到前一个
        }
        else//没有摆好全部的棋子，那只能接着往下摆咯！
            Queens(n+1,Max,Q,result);
    }
    
    int totalNQueens(int n){
        int Q[n]={-1};
        int solution=0;
        Queens(0,n,Q,solution);
        return solution;
    }
};
