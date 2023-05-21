const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// console.log("input");
// console.log(input);

// n값 숫자 형태로 반환
const n = Number(input.shift());

const arr = input.shift().split(" ").map(Number);

const sum = new Array(n + 1).fill(0);
let result = 0;

arr.unshift(0);

for (let i = 1; i <= n; i++) {
  sum[i] = arr[i] + sum[i - 1];
}

for (let i = 2; i < n; i++) {
  result = Math.max(result, sum[n] - arr[n] - arr[i] + sum[i - 1]);
}

for (let i = 2; i < n; i++) {
  result = Math.max(result, sum[n] - arr[1] - arr[i] + sum[n] - sum[i]);
}

for (let i = 2; i < n; i++) {
  result = Math.max(result, sum[i] - arr[1] + sum[n] - sum[i - 1] - arr[n]);
}
console.log(result);
