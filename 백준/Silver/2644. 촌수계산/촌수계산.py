def bfs(s,e):
    q = []
    visited = [0]*(N+1)

    q.append(s)
    visited[s] = 1

    while q:
        c = q.pop(0)
 

        if c == e: # 목적지 찾음
            return visited[e] -1 #나랑 한칸 떨어져 있으면 1촌


        # cㅇㅘ 연결된 번호인 경우 미방문이면 방문
        for n in adj[c]:
            if not visited[n]:
                q.append(n)
                visited[n] = visited[c]+1
    # 이곳의 코드를 실행했다면? (찾지 못함)
    return -1

N = int(input())
S,E = map(int,input().split())
M = int(input())


adj = [[] for _ in range(N+1)]
for _ in range(M):
    p,c = map(int, input().split())
    adj[p].append(c)
    adj[c].append(p)

answer = bfs(S,E)
print(answer)
