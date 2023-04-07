// fetch("http://localhost:3000/comments")
//     .then((response) => response.json())
//     .then((json) => console.log(json)); //전체 데이터 조회

// fetch("http://localhost:3000/comments/1")
//     .then((response) => response.json())
//     .then((json) => console.log(json)); //id로 조회

// fetch("http://localhost:3000/comments?postId=1")
//     .then((response) => response.json())
//     .then((json) => console.log(json)); //query로 postId=1로 조회

fetch("http://localhost:3000/posts", {
    method: "POST", //HTTP 요청 방법
    body: JSON.stringify({
        // 전송할 데이터
        title: "리액트",
        author: "패이스북",
    }),
    headers: {
      //헤더 값 정의
      "content-type": "application/json; charset=UTF-8", //content-type 정의
    },
  })
    .then((response) => response.json())
    .then((json) => console.log(json));