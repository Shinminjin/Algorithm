const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
let count = 0;

while (1) {
  if (input % 5 === 0) {
    console.log(input / 5 + count);
    break;
  }
    
  if (0 > input) {
    console.log(-1);
    break;
  }

  count++;
  input -= 3;
}