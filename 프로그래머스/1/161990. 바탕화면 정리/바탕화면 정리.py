def solution(wallpaper):
    answer = []
    maxx, minx, maxy, miny = 0, 100, 0, 100

    r = len(wallpaper)
    c = len(wallpaper[0])

    for x in range(r):
        for y in range(c):
            if wallpaper[x][y] == "#":
                minx = min(minx, x)
                miny = min(miny, y)
                maxx = max(maxx, x)
                maxy = max(maxy, y)


    return [minx, miny, maxx+1, maxy+1]