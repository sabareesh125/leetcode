class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = [int(i) for i in str(num)]
        dit = defaultdict(int)
        for i, n in enumerate(num):
            dit[n] = max(dit[n], i)
        
        flag = False
        for i, n in enumerate(num):
            for x in range(9, n, -1):
                if x in dit and dit[x] > i:
                    num[i], num[dit[x]] = num[dit[x]], num[i]
                    flag = True
                    break
            
            if flag: break
                
        return int(''.join(str(i) for i in num))