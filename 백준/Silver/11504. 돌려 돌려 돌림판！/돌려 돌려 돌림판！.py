test = int(input())

for _ in range(test):
    n, m = map(int, input().split(" ")) ##n = 리스트 길이, m = 자리수
    x = input().split(" ")
    y = input().split(" ")
    x = int(''.join(x))
    y = int(''.join(y))
    lis = list(map(str, input().split(" ")))

    res = []
    cnt = 0

    for i in range(len(lis)):
        st = ''
        if i + m - 1 < len(lis):
            st += ''.join(lis[i:i+m])
        else:
            k = i+m - n
            st += ''.join(lis[i:])
            st += ''.join(lis[:k])

        res.append(st)

    res = map(int, res)
    for r in res:
        if x <= r <= y:
            cnt += 1

    print(cnt)