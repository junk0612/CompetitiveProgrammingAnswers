#include<iostream>
#include<vector>
using namespace std;

int main(){
	int n,p;
	while(cin >> n >> p, n|p){
		vector<int> v(n,0);
		int cup=p;
		int num=0;
		while(1){
			if(cup!=0){
				v[num]++;
				cup--;
			}
			else if(v[num]!=0){
				cup=v[num];
				v[num]=0;
			}
			if(v[num]==p)
				break;
			num++;
			num%=n;
		}
		cout << num << endl;
	}
	return 0;
}