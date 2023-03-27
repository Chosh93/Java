// 중복 없는 로또 번호 만들기 자바스크립트로 구현하고 html 과 CSS를 이용해 출력

function lottoStart(){
    let lotto = [];
    let i=0;
    while(i < 6){
        let n = Math.floor(Math.random() * 45 + 1);
        if(! sameNum(n)){
            lotto.push(n);
            i++;
        }
    }
    function sameNum(n){
        for(let i = 0; i < lotto.length; i++){
            if(n === lotto[i]) return true;
        }
        return false;   
    }
    console.log(lotto);
    document.write(lotto);
}
