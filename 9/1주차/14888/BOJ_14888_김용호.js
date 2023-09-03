const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// console.log("input");
// console.log(input);

// 구조분해
const [N, A, operators] = input;

// 전역 변수 처리
let max = -9999999;
let min = 9999999;

// 사칙 연산 처리
const calculate = [
  (a, b) => a + b,
  (a, b) => a - b,
  (a, b) => a * b,
  (a, b) => ~~(a / b)
];

// dfs 함수
const dfs = (count = 0, result = A[0]) => {
  if (count === N - 1) {
    max = Math.max(max, result);
    min = Math.min(min, result);
  } else {
    for (let i = 0; i < 4 ; i++) {
      if (!operators[i]) {
        continue;
      }
      operators[i]--;
      dfs(count + 1, calculate[i](result, A[count + 1]));
      operators[i]++;
    }
  }
};

dfs();
console.log(max);
console.log(min);