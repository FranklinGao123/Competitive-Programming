#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin>>n;
    for (int i = 0, y, m , d; i < n; ++i) {
        cin>>y>>m>>d;
        if(2007-y>18){
            cout<<"Yes"<<"\n";
        }else if(2007-y==18 && m==2 && d<=27){
            cout<<"Yes"<<"\n";
        }else if(2007-y==18 && m==1 && d<=31) {
            cout<<"Yes"<<"\n";
        }else{
                cout<<"No"<<"\n";
            }
        }

    return 0;
}
