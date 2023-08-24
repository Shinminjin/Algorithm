const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// console.log("input");
// console.log(input);

// DP 로직 잘못된 방향으로 접근
const solution = (N, numbers) => {
  const dp = Array.from({ length: N - 1 }, () => new Array(21).fill(BigInt(0)));

  dp[0][numbers[0]] += BigInt(1);
  for (let i = 1; i < N - 1; i++) {
    for (let j = 0; j <= 20; j++) {
      if (dp[i - 1][j]) {
        if (j + numbers[i] <= 20) dp[i][j + numbers[i]] += dp[i - 1][j];
        if (j - numbers[i] >= 0) dp[i][j - numbers[i]] += dp[i - 1][j];
      }
    }
  }

  return dp[N - 2][numbers[N - 1]].toString();
};

const N = Number(input[0]);
const numbers = input[1].split(' ').map(Number);

console.log(solution(N, numbers));