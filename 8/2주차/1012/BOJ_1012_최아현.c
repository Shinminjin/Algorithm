#include<cstdio>
#include<iostream>
#include<string.h>

using namespace std;

int M, N;

int cabge[50][50] = { 0, };
int check[50][50] = { 0, };

int dx[4] = { 1,-1,0,0 }; //동서남북
int dy[4] = { 0,0,-1,1 }; 

void dfs(int y, int x) {

	check[y][x] = 1;

	for (int i = 0; i < 4; i++)
	{
		int n_y = y + dy[i];
		int n_x = x + dx[i];

		if (n_y >= 0 && n_x >= 0 && n_x < M && n_y < N && cabge[n_y][n_x] && check[n_y][n_x] == 0)
		{
			dfs(n_y, n_x);
		}	
	}
}
int main() {

	int T, K, x, y;

	cin >> T;

	for (int t = 0; t < T; t++) {
		int result = 0;
		
		cin >> M >> N >> K;

		for (int i = 0; i < K; i++) {
			cin >> x >> y;
			cabge[y][x] = 1;
		}

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if (cabge[i][j] == 1 && check[i][j] == 0)
				{
					dfs(i, j);
					result++;
				}
			}
		}
		memset(cabge, 0, sizeof(cabge));
		memset(check, 0, sizeof(check));
		cout << result << "\n";

	}
	return 0;
}
