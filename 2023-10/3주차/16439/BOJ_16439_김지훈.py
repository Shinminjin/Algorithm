from itertools import combinations
 
N,M=map(int,input().split()) 
like=[list(map(int,input().split())) for _ in range(N)]
result=0
 
# 모든 조합에 대하 모든 만족도를 계산
for comb in combinations(range(M),3): 
    c_sum=0                           # 치킨 만족도의 합
    for r in range(N):                # 각 회원별로
        p=0
        for idx in comb:
            p=max(p,like[r][idx])     
        c_sum+=p                      
    result=max(result,c_sum)          # 최대값 갱신
print(result)