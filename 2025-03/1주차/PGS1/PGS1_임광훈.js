function solution(rectangle, characterX, characterY, itemX, itemY) {
  let result = Infinity

  const visited = Array.from(Array(102), () => Array(102).fill(1))
  const m = Array.from(Array(102), () => Array(102).fill(0))
  const dy = [0, -1, 0, 1, -1, -1, 1, 1]
  const dx = [1, 0, -1, 0, 1, -1, -1, 1]

  for (let [x1, y1, x2, y2] of rectangle) {
    const x1_ = 2 * x1
    const y1_ = 2 * y1
    const x2_ = 2 * x2
    const y2_ = 2 * y2
    for (let i = x1_; i <= x2_; i++) {
      for (let j = y1_; j <= y2_; j++) {
        m[j][i] = 1
        visited[j][i] = 0
      }
    }
  }
  const q = [[characterX * 2, characterY * 2, 0]]

  while (q.length) {
    const [nowX, nowY, len] = q.shift()
    visited[nowY][nowX] = 1
    if (nowX === itemX * 2 && nowY === itemY * 2) {
      result = Math.min(result, len)
    } else {
      for (let d = 0; d < 4; d++) {
        const my = nowY + dy[d]
        const mx = nowX + dx[d]
        if (m[my][mx] && !visited[my][mx]) {
          let cnt = 0
          for (let d = 0; d < 8; d++) {
            const my_ = my + dy[d]
            const mx_ = mx + dx[d]
            cnt = cnt + m[my_][mx_]
          }
          if (cnt !== 8) {
            q.push([mx, my, len + 1])
          }
        }
      }
    }
  }
  return result / 2
}
