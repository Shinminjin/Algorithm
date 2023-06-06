function solution(s) {
  let changeCnt = 0;
  let zeroCnt = 0;

  // s가 1아닐때 까지
  while (s.length !== 1) {
    let stackLen = s.length;

    s = s.split("0").join(""); // 배열 >> 문자열

    changeCnt++;
    zeroCnt += stackLen - s.length;

    s = s.length.toString(2);
  }

  return [changeCnt, zeroCnt];
}
