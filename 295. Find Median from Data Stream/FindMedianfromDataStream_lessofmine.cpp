class MedianFinder {
private:
    multiset<int> big;
    multiset<int> small;
    int bs=0;
    int ss=0;
public:

    // Adds a number into the data structure.
    void addNum(int num) {
        if(bs==0 && ss==0)
        {
            ss++;
            small.insert(num);
        }
        else
        {
            int center= this->findMedian();
            if(num>center)
            {
                //进大堆
                bs++;
                big.insert(num);
            }
            else{
                //进小堆
                ss++;
                small.insert(num);
            }
            
            //调整
            if( ss>bs && ss-bs>1)
            {
                ss--;
                bs++;
                int i= *small.rbegin();
                small.erase(small.find(i));
                big.insert(i);
            }
            else if(bs>ss && bs-ss>1){
                bs--;
                ss++;
                int i= *big.begin();
                big.erase(big.find(i));
                small.insert(i);
            }
        }
    }

    // Returns the median of current data stream
    double findMedian() {
        if(bs==ss)
            return (double)(*big.begin()+*small.rbegin())/2;
        else if(bs>ss)
            return *big.begin();
        else if(ss>bs)
            return *small.rbegin();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();