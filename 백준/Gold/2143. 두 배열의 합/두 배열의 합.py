import bisect

T = int(input())  # 부 배열의 합으로 만족되야 하는 값
n = int(input())  # 배열 A의 원소 개수
A = list(map(int, input().split()))  # 배열 A
m = int(input())  # 배열 B의 원소 개수
B = list(map(int, input().split()))  # 배열 B

result = 0  # 출력할 값 초기화
Asum, Bsum = A, B  # 각 배열로 초기화
for i in range(n-1):
    for j in range(i + 1, n):
        # print(i)
        # print(j)
        Asum.append(sum(A[i:j + 1]))  # 배열 A의 모든 부배열의 합을 추가해준다.
        # print(Asum)
for s in range(m-1):
    for e in range(s + 1, m):
        Bsum.append(sum(B[s:e + 1]))  # 배열 A의 모든 부배열의 합을 추가해준다.

Asum.sort();
Bsum.sort()

for i in range(len(Asum)):
    l = bisect.bisect_left(Bsum, T - Asum[i])
    r = bisect.bisect_right(Bsum, T - Asum[i])
    result += r - l
print(result)
