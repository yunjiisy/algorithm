def get_num(x, y, oper):
    if oper == '<':
        return x < y
    else:
        return x > y

def dfs(idx, num):
    global max_ans, min_ans  # 전역 변수로 선언

    # print(f"DFS 호출: idx={idx}, num={num}")

    if idx == k + 1:
        max_ans = max(max_ans, num)
        min_ans = min(min_ans, num)
        return

    for i in range(10):
        if not check[i]:
            if idx == 0 or get_num(num[-1], str(i), oper[idx-1]):
                # print(f"  숫자 선택: {i}")
                check[i] = True
                dfs(idx + 1, num + str(i))
                check[i] = False

k = int(input())
oper = list(input().split())

check = [False] * 10
max_ans = ""
min_ans = "9876543210"

dfs(0, '')

print(max_ans)
print(min_ans)
