function solution(begin, target, words) {
    var answer = 0

    if (!words.includes(target)) return answer
    
    return bfs(words, begin, target, answer)
}

// bfs
function bfs(words, begin, target, answer) {
    let queue = [begin]
    let visited = new Set()
    
    visited.add(begin)
    
    while (queue.length > 0) {    
        for (let i = 0; i < queue.length; i++) {
            let node =  queue.shift()

            if (node === target) {
                return answer
            }

            for (let word of words) {
                if (!visited.has(word) && compStrValue(node, word)) {
                    visited.add(word)
                    queue.push(word)
                }
            }
        }
        answer++
    }
    return answer = 0
}

// 한 문자만 다른지 확인
function compStrValue(word1, word2) {
    let cnt = 0
    for (let i = 0; i < word1.length; i++) {
        if (word1[i] !== word2[i]) {
            cnt++
        }
        if (cnt > 1) {
            return false
        }
    }
    
    return cnt === 1
}
