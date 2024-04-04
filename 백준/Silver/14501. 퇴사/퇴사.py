N = int(input())
schedule = [list(map(int, input().split())) for _ in range(N)]

profit = [0]*N

for i in range(N):
    if i + schedule[i][0] <= N:
        profit[i] = schedule[i][1]
        for j in range(i):
            if j + schedule[j][0] <= i:
                profit[i] = max(profit[i], profit[j] + schedule[i][1])

print(max(profit))