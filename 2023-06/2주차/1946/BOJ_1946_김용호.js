const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";

let input = fs.readFileSync(filePath).toString().trim().split("\n");

const T = input[0]; // TC 총 갯수
let applicants = [];
let result = [];

for (let i = 1; i <= T; i++) {
  let N = input[i];
  applicants.push(
    input
      .splice(i + 1, N)
      .map((item) => item.split(" "))
      .sort((a, b) => a[0] - b[0])
  );
}

for (let i = 0; i < applicants.length; i++) {
  let length = applicants[i].length;
  let count = 1;
  let standard = Number(applicants[i][0][1]);

  for (let j = 1; j < length; j++) {
    if (Number(applicants[i][j][1]) < standard) {
      count++;
      standard = Number(applicants[i][j][1]);
    }
  }
  result.push(count);
}

console.log(result.join("\n"));
