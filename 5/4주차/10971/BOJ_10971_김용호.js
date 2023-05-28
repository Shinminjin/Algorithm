const fs = require("fs");
// 로컬 환경 (text 파일 읽어오기) 백준 환경(os 기준 linux일 때 stdin 바로바게 작성)
// node.js 테스트 하기와 같이 작성
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";

let data = require("fs").readFileSync(filePath).toString().trim().split("\n");
// console.log(data);
let n = +data.shift(); // 첫번째 값 반환
let city = [];

// console.log(data);
for (let temp of data) {
  city.push(temp.split(" ").map((e) => +e));
}
// console.log("city 값", city);

const dfs = (n, city) => {
  let answer = [];
  let visited = new Array(n).fill(0); // 방문한 지역 변경
  let tmp = [];

  const dfs = (cnt, curNode) => {
    if (cnt === n - 1) visited[0] = 0;
    if (cnt === n) {
      if (visited.every((e) => e === 1)) {
        answer.push(tmp.reduce((a, c) => a + c, 0));
      }
    } else {
      for (let i = 0; i < n; i++) {
        if (!city[curNode][i]) continue; // 값이 없으면 아래 내용 생략
        if (!visited[i] && curNode !== i) {
          visited[i] = 1;
          tmp.push(city[curNode][i]);
          dfs(cnt + 1, i);
          tmp.pop();
          visited[i] = 0;
        }
      }
    }
  };

  visited[0] = 1;
  dfs(0, 0);

  return Math.min(...answer);
};

console.log(dfs(n, city));
