const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

// 문제 해결 실패 input값을 구조분해서 가져오는게 편한듯
let answer = 0;
const N = +input[0][0];
const A = input[1].sort((a,b)=>{return a-b});
const B = input[2].sort((a,b)=>{return b-a});

for(let i = 0; i<N; i++){
  answer+=A[i]*B[i]
}

console.log(answer)