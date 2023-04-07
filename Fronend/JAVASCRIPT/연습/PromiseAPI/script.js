// Fetch API : XMLHttpRequest 방식과 가장 큰 차이점은 PromiseAPI 방식으로 구현
// fetch("https://jsonplaceholder.typicode.com/posts/1")
// .then((reponse) => reponse.json())
// .then((json) => console.log(json))
// .catch(error => console.error(error));

// POST - 데이터 생성
// fetch("https://jsonplaceholder.typicode.com/posts", {
//     method : "POST", // HTTP 요청 방법
//     body : JSON.stringify({
//         // 전송할 데이터
//         title : "Test Promise",
//         name : "조씨",
//         userId : 1,
//     }),
//     headers : {
//         // 헤더값 정의
//         "content-type" : "application/json; charset=UTF-8" // content-type 정의
//     },
// })
// .then((response) => response.json())
// .then((json) => console.log(json));

// PUT - 데이터 수정
// fetch("https://jsonplaceholder.typicode.com/posts/1", {
//     method : "PUT",
//     body : JSON.stringify({
//         id : 1,
//         title : "Test Promise",
//         name : "조씨",
//         userid : 1,
//     }),
//     headers : {
//         "content-type" : "application/json; charset=UTF-8",
//     },
// })
// .then((response) => response.json())
// .then((json) => console.log(json));

// DELETE - 데이터 삭제
// fetch("https://jsonplaceholder.typicode.com/posts/1", {
//     method : "DELETE",
// });

// Promise를 통한 비동기 제어방법 : 결과값은 내부객체이기 때문에 then과 catch로만 접근이 가능
const successPromise = new Promise(function (resolve, reject){
    setTimeout(function(){
        resolve("Success");
    }, 3000);
});
successPromise.then(function(value){
    console.log(value); // value인자가 결과 갑 " Succeess " 임.
});
successPromise.then((value) => console.log(value));
