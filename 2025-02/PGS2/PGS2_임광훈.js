function solution(tickets) {
  var answer = []
  const router = tickets.sort().reduce((acc, [from, to]) => {
    ;(acc[from] = acc[from] || []).push([to, 0])
    return acc
  }, {})
  console.log(router)

  const dfs = (dfsKey, dfsAnswer, dfsRoute, dfsPaths) => {
    if (dfsPaths === 0) {
      answer.push(dfsAnswer)
      return
    }
    if (dfsRoute[dfsKey]) {
      for (let i = 0; i < dfsRoute[dfsKey].length; i++) {
        const [newKey, n] = dfsRoute[dfsKey][i]
        if (n === 0) {
          dfsAnswer.push(newKey)
          dfsRoute[dfsKey][i][1] = 1
          dfs(newKey, dfsAnswer.slice(), dfsRoute, dfsPaths - 1)
          dfsAnswer = dfsAnswer.slice(0, dfsAnswer.length - 1)
          dfsRoute[dfsKey][i][1] = 0
        }
      }
    }
  }
  dfs("ICN", ["ICN"], router, tickets.length)
  return answer.sort((el) => el.length)[0]
}
