class NumArray {
private:
vector<int> c;
vector<int> s;
int lenc;
int lens;
public:
NumArray(vector<int> &nums) {
    c.resize(nums.size()+1);
    s = nums;
    lens=s.size();
    lenc=c.size();
    for(int i = 0; i < s.size(); i++){
        add(i+1,nums[i]);
    }
}

int lowbit(int x){
    return x&(-x);//!!!! not ~
}
void add(int pos, int value){
    while(pos < lenc){
        c[pos] += value;
        pos += lowbit(pos);
    }
}
int sum(int pos){
    int res = 0;
    while(pos > 0){
        res += c[pos];
        pos -= lowbit(pos);
    }
    return res;
}

void update(int i, int val) {
    add(i+1,val-s[i]);
    s[i] = val;
}

int sumRange(int i, int j) {
    return sum(j+1) - sum(i);
}
};

// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);