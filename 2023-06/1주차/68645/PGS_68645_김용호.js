function solution(n) {
  //     n층이고 바닥은 n개

  let top = []; // n층의 탑 모형 구성
  let result = [];

  //초기값을 위해서 -1로 변수 지정
  let layer = -1;
  let width = 0;
  let number = 1;

  // 요소가 모두 0인 배열 생성
  for (let i = 1; i < n + 1; i++) {
    let tmp = Array(i).fill(0);
    top.push(tmp);
  }

  // console.log(top)
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++) {
      // Top >> Bot
      if (i % 3 === 0) {
        layer += 1;
        // 옆으로 >>
      } else if (i % 3 === 1) {
        width += 1;
        // 전체 위로
      } else {
        layer -= 1;
        width -= 1;
      }

      top[layer][width] = number;
      number += 1;
    }
  }
  console.log(top);
  console.log(top[1][0]);

  // 실수 append 사용 못함
  for (let i = 0; i < n; i++) {
    // console.log(top[i])
    result = result.concat(top[i]);
  }

  return result;
}
