#include <iostream>
#include <vector>
#include <string>
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<string> vs;
typedef pair<int, int> pii;
typedef long long ll;
#define ALL(a) (a).begin(),(a).end()
#define RALL(a) (a).rbegin(),(a).rend()
#define EXIST(s,e) ((s).find(e)!=(s).end())
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)

int main(){
	int x,y;
	while(cin >> x >> y, x|y){
		vvi field(y,vi(x));
		REP(i,y){
			REP(j,x){
				cin >> field[i][j];
			}
		}
		vvi dp(y,vi(x,0));
		REP(i,y){
			REP(j,x){
				if(i==0&&field[i][j]==0){
					dp[i][j]=1;
				}
				if(i<y-1&&field[i][j]==0){
					if(j>0&&field[i+1][j-1]==0){
						dp[i+1][j-1]+=dp[i][j];
					}
					if(j<x-1&&field[i+1][j+1]==0){
						dp[i+1][j+1]+=dp[i][j];
					}
					if(field[i+1][j]!=1){
						dp[i+1][j]+=dp[i][j];
					}
				}
				if(i<y-2&&field[i][j]==2){
					if(field[i+2][j]!=1){
						dp[i+2][j]+=dp[i][j];
					}
				}
			}
		}
		int result=0;
		REP(i,x){
			result+=dp[y-1][i];
			if(y>=2&&field[y-2][i]==2){
				result+=dp[y-2][i];
			}
		}
		cout << result << endl;
	}
}
