#include<iostream>
#include<stack>
#include<vector>
#include<cstring>
using namespace std;

/**
 * BOJ 1012 유기농 배추
 * 
 * DFS
*/

int m = 0, n = 0, k = 0;
int map[50][50] = {0};
bool visit[50][50] = {0};

void dfs(int x, int y) {
    visit[y][x] = true;

    for(int i = y - 1; i <= y + 1; i++) {
        if(i >= 0 && i < n) {
            if(!visit[i][x] && map[i][x]) {
                dfs(x, i);
            }
        }
    }
        
    for(int i = x - 1; i <= x + 1; i++) {
        if(i >= 0 && i < m) {
            if(!visit[y][i] && map[y][i]) {
                dfs(i, y);
            }
        }
    }
}


int main() {
    int testCase = 0;
    int sum = 0;
    vector<int> result;

    cin >> testCase;

    for(int i = 0; i < testCase; i++) {
        sum = 0;

        cin >> m >> n >> k;
        for(int i = 0; i < k; i++) {
            int x, y;
            cin >> x >> y;
            map[y][x] = 1;
        }


        for(int y = 0; y < 50; y++) {
            for(int x = 0; x < 50; x++) {
                if(!visit[y][x] && map[y][x]) {
                    dfs(x, y);
                    sum++;
                }
            }
        }
        
        result.push_back(sum);
        memset(map, 0, sizeof(map));
        memset(visit, 0, sizeof(visit));
    }

    for(int a : result) cout << a << "\n";
}