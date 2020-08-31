#include <iostream>
#include <string>

using namespace std;

string a,b,c;
char d[27];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    getline(cin,a);
    getline(cin,b);
    getline(cin,c);
    for (int i = 0; i < a.length(); ++i) {
        if(b[i]!=' ')
            d[b[i]-65] = a[i];
        else
            d[26] = a[i];
    }
    for (int i = 0; i < c.length(); ++i) {
        if(c[i]!=' '){
            if(d[c[i]-65]!='\0')
                cout<<d[c[i]-65];
            else
                cout<<".";
        }else
            cout<<d[26];
    }
}
