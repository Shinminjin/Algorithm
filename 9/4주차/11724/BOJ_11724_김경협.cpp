#include<iostream>
#include<vector>
using namespace std;

/**
 * BOJ 11724 연결 요소의 개수
 * 
 * DFS로 그래프 탐색
 * 
*/
const int MAX = 1001;

vector<int> adj[MAX];
int visit[MAX];
int n = 0, m = 0;


void DFS(int startNode)
{
    visit[startNode] = true;
    for(auto a : adj[startNode])
        if(!visit[a])
        DFS(a);
}

int main()
{
    int sum = 0;
    cin >> n >> m;

    for(int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for(int i = 0; i < n; i++)
        if(!visit[i + 1])
        {
            DFS(i + 1);
            sum++;
        }

    cout << sum;
}