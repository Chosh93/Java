
// createElement() : 요소 노드를 생성
// const aEl = document.createElement("div");
// // <기준노드>.appendChild(<추가할 자식노드>)
// document.body.appendChild(aEl);
// aEl.innerText = "TEST";

// div 태그를 생성하고 하위에 메뉴 리스트 추가하기
// div, ui, li
// 메뉴 리스트
// - 돈까스
// - 오므라이스
// - 짜장면
// - 짬뽕
// - 탕수육
const dEl = document.querySelector("#menu");
dEl.innerText = "메뉴리스트";
const uEl = document.createElement("ui");
dEl.appendChild(uEl);
const lEl1 = document.createElement("li");
const lEl2 = document.createElement("li");
const lEl3 = document.createElement("li");
const lEl4 = document.createElement("li");
const lEl5 = document.createElement("li");
lEl1.innerText = "돈까스";
lEl2.innerText = "오므라이스";
lEl3.innerText = "짜장면";
lEl4.innerText = "짬뽕";
lEl5.innerText = "탕수육";
uEl.appendChild(lEl1);
uEl.appendChild(lEl2);
uEl.appendChild(lEl3);
uEl.appendChild(lEl4);
uEl.appendChild(lEl5);

// div -> ui -> li 태그를 cascade 하려면 
// <부모태그>.appendChild(<자식태그>)

function deleteMenu(){
        uEl.removeChild(lEl1);
        uEl.removeChild(lEl2);
        uEl.removeChild(lEl3);
        uEl.removeChild(lEl4);
        uEl.removeChild(lEl5);

}