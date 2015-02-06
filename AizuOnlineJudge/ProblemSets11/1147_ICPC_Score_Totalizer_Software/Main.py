# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

def main(n):
    mi=1000
    ma=0
    su=0
    for i in range(n):
        num = int(raw_input())
        su += num
        ma = max(ma, num)
        mi = min(mi, num)
    su -= ma + mi
    print su/(n-2)

while 1:
    n = int(raw_input())
    if n==0:
        break
    main(n)
    
