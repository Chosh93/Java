// let doc = document.firstChild;
// console.log(doc);

// let html = document.firstElementChild; // 첫번째 자식 노드를 반환
// console.log(html);


// getElementById("id") : id 속성값가 일치하는 요소 노드 1개만 선택
const el = document.getElementById("title");
//console.log(el);

// getElementByClassName("class") : class 속성값과 일치하는 요소 노드 모두 선택
// 여러개의 요소 노드가 선택되며 배열과 유사한 형태로 관리됨
const classEl = document.getElementsByClassName("text");
//console.log(classEl[1]);


//향상된 for문과 유사
for (let el of classEl) {
    //console.log(el);
}

// getElementByTagName("Tag") : 태그명과 일치하는 요소 노드 모두 선택
const tagEl = document.getElementsByTagName("p");
for (let el of tagEl) {
    //console.log(el);
}

// CSS 선택자로 사용하기 : query메소드(querySelector, querySelectorAll)
const qEl = document.querySelector(".box-1");
//console.log(qEl);

const qEls = document.querySelector(".box-1 .text");
// console.log(qEls[0]);
// console.log(qEls[1]);

// 노드 조작하기
// textContent : 요소 노드의 모든 텍스트에 접근
// innerText : 요소 노드의 텍스트 중 웹 브라우저에 표시되는 텍스트 접근
// innerHTML : 요소 노드의 텍스트 중 html태그를 포함한 텍스트 접근
let txtCont = document.getElementById("title2").textContent;
let inText = document.getElementById("title2").innerText;
let inHtml = document.getElementById("title2").innerHTML = "<h1>TestTest</h1>";

console.log(txtCont);
console.log(inText);
console.log(inHtml);

// 스타일 조작 하기 : 선택된 노드의 스타일(CSS) 지정하거나 변경
const sEl = document.querySelectorAll(".text");
for (let el of sEl) {
    el.style.backgroundColor = "red";
    el.style.fontSize = "50px";
    el.style.color = "white";
}