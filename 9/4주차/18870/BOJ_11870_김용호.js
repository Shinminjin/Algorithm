const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

const setArr = input[0].split(' ').map(Number).sort((a,b)=>a-b);
const set = new Set(setArr);
const map = new Map();

[...set].forEach((item, index) => {
    map.set(item, index);
})

let answer = '';
input[0].split(' ').forEach((item, index) => {
   answer += map.get(+item) + ' ';
})

console.log(answer);