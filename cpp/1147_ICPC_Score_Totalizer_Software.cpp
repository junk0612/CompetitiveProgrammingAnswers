#include <iostream>
using namespace std;

int main(){
	
	while(true){
		int n;
		cin >> n;
		if(n==0) break;
		int max=0,min=1000,sum=0;
		for(int i=0;i<n;i++){
			int a;
			cin >> a;
			sum+=a;
			if(max<a) max=a;
			if(min>a) min = a;
		}
		int result = (sum-max-min) / (n-2);
		cout << result << endl;
	}
	
	return 0;
}