const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";

let input = fs.readFileSync(filePath).toString().trim().split("\n").map(Number);

const mod = 1000000009;
const answer = [];
const MAX = Math.max(...input);

// 해당 내용 생각못함
let dp = Array.from(Array(MAX + 1), () => [0]);
dp[0] = [0];
dp[1] = [0, 1, 0, 0];
dp[2] = [0, 0, 1, 0];
dp[3] = [0, 1, 1, 1];

for (let i = 4; i <= MAX; i++) {
  dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
  dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
  dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
}

for (let t = 0; t < N; t++) {
  answer.push(
    dp[input[t]].reduce((r, v) => {
      return (r + v) % mod;
    }, 0)
  );
}

console.log(answer.join("\n"));
