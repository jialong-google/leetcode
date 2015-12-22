class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int,int>> h;
        vector<pair<int,int>> re;
        
        for(int i=buildings.size()-1;i>=0;i--){
            h.push_back(make_pair(buildings[i][0],-buildings[i][2]));//we should add minus here in order to let it come first.
            h.push_back(make_pair(buildings[i][1],buildings[i][2]));
        }
        sort(h.begin(),h.end());//here we let 'add' be the first. then comes 'delete'
        //make a heap
        multiset<int> heap;
        heap.insert(0);
        int cur=0;
        for(int i=0;i<h.size();i++)
        {
            if(h[i].second <0)
            {
                heap.insert(-h[i].second);
            }
            else
            {
                heap.erase(heap.find(h[i].second));//and here, must use find, because find returns One result, 
                //but if we don't, the node with the value would ALL be removed.
            }
            
            if(cur!=*heap.rbegin())
            {
                cur=*heap.rbegin();
                re.push_back(make_pair( h[i].first, cur ));
            }
        
        }
        return re;
    }
};