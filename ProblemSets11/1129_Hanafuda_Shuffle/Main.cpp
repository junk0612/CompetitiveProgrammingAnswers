#include<iostream>
#include<vector>

using namespace std;

int main(){
	int n,r;
	while(cin >> n >> r,n|r){
		vector<int> v;
		for(int i=0;i<n;i++)
			v.push_back(n-i);
		for(int i=0;i<r;i++){
			int p,c;
			cin >> p >> c;
			p--;
			vector<int> a;
			for(int j=p;j<p+c;j++)
				a.push_back(v[j]);
			for(int j=0;j<p;j++)
				a.push_back(v[j]);
			for(int j=p+c;j<n;j++)
				a.push_back(v[j]);
			v=a;
		}
		cout << v[0] << endl;
	}
	return 0;
}