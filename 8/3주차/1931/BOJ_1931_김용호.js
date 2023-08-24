const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// console.log("input");
// console.log(input);

let n = Number(input[0]);
let arr = new Array(n + 1);

for (let i = 0; i < n; i++) {
  arr[i + 1] = input[i + 1].split(" ").map(Number);
}
arr.sort((a, b) => (a[1] === b[1] ? a[0] - b[0] : a[1] - b[1]));

let cur = arr[0][1];
let ans = 1;

for (let i = 1; i < n; i++) {
  if (arr[i][0] >= cur) {
    cur = arr[i][1];
    ans++;
  }
}
console.log(ans);
