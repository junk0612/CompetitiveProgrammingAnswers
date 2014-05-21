#include <iostream>
#include <vector>
using namespace std;

int main(){
	int n,m;
	while(cin >> n, n){
		vector< vector<bool> > field(21,vector<bool>(21));
		for(int i=0;i<21;i++)
			for(int j=0;j<21;j++)
				field[i][j]=false;
		for(int i=0;i<n;i++){
			int x,y;
			cin >> x >> y;
			field[x][y]=true;
		}
		int result=0;
		int nx=10,ny=10;
		if(field[nx][ny]){
			result++;
			field[nx][ny]=false;
		}
		cin >> m;
		for(int i=0;i<m;i++){
			char d;
			int l;
			cin >> d >> l;
			for(int j=0;j<l;j++){
				switch(d){
				case 'N':
					ny++;
					if(field[nx][ny]){
						result++;
						field[nx][ny]=false;
					}
					break;
				case 'E':
					nx++;
					if(field[nx][ny]){
						result++;
						field[nx][ny]=false;
					}
					break;
				case 'S':
					ny--;
					if(field[nx][ny]){
						result++;
						field[nx][ny]=false;
					}
					break;
				case 'W':
					nx--;
					if(field[nx][ny]){
						result++;
						field[nx][ny]=false;
					}
					break;
				}
			}
		}
		if(result==n)
			cout << "Yes" << endl;
		else
			cout << "No" << endl;
	}
	return 0;
}