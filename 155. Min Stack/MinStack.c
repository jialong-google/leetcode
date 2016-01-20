class MinStack {
    vector<int> stack;
    vector<int> m;
public:
    void push(int x) {
        stack.push_back(x);
        if(m.empty() || x<= m[m.size()-1])
            m.push_back(x);
    }

    void pop() {
        int x= stack[stack.size()-1];
        stack.pop_back();
        if(x==m[m.size()-1])
            m.pop_back();
    }

    int top() {
        return stack[stack.size()-1];
    }

    int getMin() {
        return m[m.size()-1];
    }
};