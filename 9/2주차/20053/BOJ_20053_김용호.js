const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");


const stnadNum = Number(input[0]);
let testcase = input.slice(1);

for (let i = 1; i <= stnadNum; i++) {
  const testArr = temp[1].split(' ').map((x) => +x);
  const min = Math.min(...testArr);
  const max = Math.max(...testArr);
  
  console.log(min, max);
  testcase = testcase.splice(2);
}