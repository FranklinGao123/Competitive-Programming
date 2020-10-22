#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct box{
    int x, y ,z,vol;
};

bool cmp(box x, box y){
    return x.vol<y.vol;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin>>n;
    vector<box> standard;
    for (int i = 0; i < n; ++i) {
        vector<int> input;
        int a,b,c,vol;
        cin>>a>>b>>c;
        vol = a*b*c;
        input.push_back(a);
        input.push_back(b);
        input.push_back(c);
        sort(input.begin(),input.end());
        standard.push_back({input[0],input[1],input[2],vol});
    }
    sort(standard.begin(),standard.end(),cmp);
    int m;
    cin>>m;
    for (int i = 0; i < m; ++i) {
        vector<int> box;
        int a,b,c;
        cin>>a>>b>>c;
        box.push_back(a);
        box.push_back(b);
        box.push_back(c);
        sort(box.begin(), box.end());
        bool done = false;
        for (int j = 0; j < n; ++j) {
            if(standard[j].x>=box[0] && standard[j].y>=box[1]&&standard[j].z>=box[2]){
                cout<<standard[j].vol<<"\n";
                done = true;
                break;
            }
        }
        if(!done){
            cout<<"Item does not fit.\n";
        }
    }

}
