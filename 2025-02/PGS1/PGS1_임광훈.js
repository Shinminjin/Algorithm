function solution(begin, target, words) {
  if (!words.includes(target)) return 0

  let answer = Infinity
  const wordLen = words[0].length
  const visited = [...new Array(words.length).fill(0)]

  const check = (a, b) => {
    let diff = 0
    for (i = 0; i < wordLen; i++) {
      if (a[i] !== b[i] && ++diff > 1) return false
    }
    return diff === 1
  }

  const dfs = (now, cnt) => {
    if (now === target) {
      answer = Math.min(answer, cnt)
    } else {
      visited.forEach((v, i) => {
        if (!v && check(now, words[i])) {
          visited[i] = 1
          dfs(words[i], cnt + 1)
          visited[i] = 0
        }
      })
    }
  }
  dfs(begin, 0)

  return answer === Infinity ? 0 : answer
}
