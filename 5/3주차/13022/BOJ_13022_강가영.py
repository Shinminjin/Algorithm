n = input()

wcnt = n.count('w')
ocnt = n.count('o')
lcnt = n.count('l')
fcnt = n.count('f')

if wcnt == ocnt == lcnt == fcnt :
    wolfCnt = n.count('wolf')
    n = n.replace('wolf', '')

    if n[0] == 'w' :
        for i in range(len(n) + 1) :
            if n[i-1] == 'f' and n[i] == 'w' :
                print('w')
            elif n[i-1] == 'w' and n[i] == 'o':
                print('o')
            elif n[i-1] == 'o' and n[i] == 'l' :
                print('l')
            elif n[i-1] == 'l' and n[i] == 'f' :
                print('f')
    else :
        print('-1')
else :
    print('-1')