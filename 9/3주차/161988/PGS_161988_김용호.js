function solution(sequence) {
  var answer = 0
  const pSeq = []
  const mSeq = []

  for(let i=0; i<sequence.length; i++) {
      
      if(i === 0) {
          pSeq.push(sequence[i])
          mSeq.push(-sequence[i])

      } else if(i%2 === 0) {  
          pSeq.push(Math.max(pSeq[i-1] + sequence[i], sequence[i]))
          mSeq.push(Math.max(mSeq[i-1] - sequence[i], -sequence[i]))
          
      } else {
          pSeq.push(Math.max(pSeq[i-1] - sequence[i], -sequence[i]))
          mSeq.push(Math.max(mSeq[i-1] + sequence[i], sequence[i]))
      }

      answer = Math.max(answer, pSeq[i], mSeq[i])
  }

  return answer
}