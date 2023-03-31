
function changeBg(color) {
    let result = document.querySelector('#result');
    result.style.backgroundColor = color;
}

function showDetail() {
    document.querySelector('#desc').style.display = "block";	// 상세 설명 부분을 화면에 표시
    document.querySelector('#open').style.display = "none";   // '상세 설명 보기' 단추를 화면에서 감춤
  }

  function hideDetail() {
    document.querySelector('#desc').style.display = "none";	   // 상세 설명 부분을 화면에서 감춤
    document.querySelector('#open').style.display = "block";	 // '상세 설명 보기' 단추를 화면에 표시
  }
