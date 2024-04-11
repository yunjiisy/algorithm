from bisect import bisect_left, bisect_right

T = int(input())  # 부 배열의 합으로 만족되야 하는 값
n = int(input())  # 배열 A의 원소 개수
A = list(map(int, input().split()))  # 배열 A
m = int(input())  # 배열 B의 원소 개수
B = list(map(int, input().split()))  # 배열 B

result = 0  # 출력할 값 초기화
# a -> A의 부 배열의 합 배열, b-> B의 부 배열의 합 배열
a, b = A, B  # 각 배열로 초기화 (요소 하나인 부 배열의 합)
for i in range(n-1):
    for j in range(i + 1, n):
        a.append(sum(A[i:j + 1]))  # 배열 A의  부 배열의 합을 추가
for i in range(m-1):
    for j in range(i + 1, m):
        b.append(sum(B[i:j + 1]))  # 배열 B의  부 배열의 합을 추가

a.sort();
b.sort()
for i in range(len(a)):
    target = T - a[i]
    l = bisect_left(b, target)
    r = bisect_right(b, target)
    result += r - l
print(result)
