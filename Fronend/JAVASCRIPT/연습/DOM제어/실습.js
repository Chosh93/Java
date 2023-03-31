function insert() {
    let newItem = document.createElement("li"); // ul태크 아래에 추가할 요소 노드 생성
    let subject = document.querySelector("#subject");
    
    //HTML 문서에 새로운 텍스트 노드를 만듦
    let newText = document.createTextNode(subject.value);

    //텍스트 노드를 li 노드의 자식 노드로 추가
    newItem.appendChild(newText);

    let itemList = document.querySelector("#itemList");

    //insertBefore() 메서드는 DOM요소를 특정 요소의 이전에 삽입합니다.
    //자식 노드 중 첫번째 노드 앞에 추가
    itemList.insertBefore(newItem,itemList.childNodes[0]);
    
    subject.value = "";
    let items = document.querySelectorAll("li");
    for(let e of items){
        e.addEventListener("click", function(){
            console.log(e)
            if(this.parentNode){ // 클리 이벤트가 발생한 요소의 부모노드가 있으면..
                this.parentNode.removeChild(this);
            }
        });
    }
}