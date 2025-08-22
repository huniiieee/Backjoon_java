def solution(cards1, cards2, goal):
    answer = 'Yes'
    cnt1,cnt2=0,0
    
    for word in goal:
        if word in cards1:
            idx=cards1.index(word)
            if idx>cnt1:
                answer='No'
                break
            else:
                cnt1+=1
        if word in cards2:
            idx=cards2.index(word)
            if idx>cnt2:
                answer='No'
                break
            else:
                cnt2+=1
            
    return answer