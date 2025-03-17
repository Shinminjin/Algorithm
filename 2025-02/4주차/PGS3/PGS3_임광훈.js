function solution(land) {
  const lenY = land.length
  const lenX = land[0].length
  const dx = [0, 1, 0, -1]
  const dy = [1, 0, -1, 0]

  const oilspot = Array(lenX).fill(0)
  // 방문여부
  const visited = Array.from(Array(lenY), () => Array(lenX).fill(false))

  // 석유량 파악
  for (x = 0; x < lenX; x++) {
    for (y = 0; y < lenY; y++) {
      if (!visited[y][x] && land[y][x] === 1) {
        let oil = 1
        visited[y][x] = true
        const queue = [[y, x]]
        const xSet = new Set()
        while (queue.length > 0) {
          const [my, mx] = queue.shift()
          xSet.add(mx)

          for (d = 0; d < 4; d++) {
            const ny = my + dy[d]
            const nx = mx + dx[d]
            if (
              0 <= ny &&
              ny < lenY &&
              0 <= nx &&
              nx < lenX &&
              land[ny][nx] === 1 &&
              !visited[ny][nx]
            ) {
              oil++
              queue.push([ny, nx])
              visited[ny][nx] = true
            }
          }
        }
        xSet.forEach((el) => {
          oilspot[el] += oil
        })
      }
    }
  }
  return Math.max(...oilspot)
}
