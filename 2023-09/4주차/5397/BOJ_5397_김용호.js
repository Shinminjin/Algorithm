const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

function stealPassword(str) {
    let front = [];
    let back = [];
    str.forEach((temp) => {
        if (temp == '-') {
            front.length == 0 || front.pop();
        }
        else if (temp == '>') {
            back.length == 0 || front.push(back.pop());
        }
        else if (temp == '<') {
            front.length == 0 || back.push(front.pop());
        }
        else {
            front.push(temp);
        }
    })
    console.log(front.join('')+back.reverse().join(''));
}
const T = input.shift();

for (let i = 0; i<T; i++) {
  stealPassword(input[i].split(''))
}
