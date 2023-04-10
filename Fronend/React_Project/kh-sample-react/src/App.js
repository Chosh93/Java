import './App.css';

function App() {
  const name = "곰돌이";
  const subject = "리엑트"
  const member = {
    name : "호랑이",
    job : "개발자",
    addr : "경기도",
    gender : "남성"
  };

  function getGeeting(user){
    return (user) ? (<h1>환영합니다. {member.name}</h1>) : (<h1>환영합니다. 방문자님</h1>);
  };

  // 리액트에서 DOM요소에 스타일을 적용할 때는 문자열 형태가 아닌 개체 형태로 넣어야 한다.
  // 스타일 이름중에서 background-color처럼 하이픈이 포함되어 있으면 카멜표기법으로 변경 해야 한다.
  const style = {
    backgroundColor : "#222",
    color : "royalBlue",
    fontSize : "2em"
  };
  
  // return 안에는 if문을 사용할 수 없음.
  // 조건에 따라 다른 렌더링을 해야 할 경우 JSX밖에서 if문을 사용해 사전에 값을 설정하거나
  // 다항연산자와 AND연사자 사용 가능
  // &&는 앞이 참이면 뒤를 참조 거짓이면 참조 ㄴㄴ
  return (
    <>
      <p>환영 합니다. {name}님...</p>
      <p>오늘은 화창한 봄 날 입니다.</p>
      {subject === "리액트" ? (<h1>리액트입니다.</h1>) : (<h2>리액트가 아닙니다..</h2>)}
      {name === "곰돌이" && <h1>리액트 화면을 갱신합니다.</h1>}
      <h1 style={style}>스타일 객체 Test...</h1>

      {/* class 키워드는 JSX문법에서는 className으로 변경해야함.(카멜표기법) */}
      <div className="App">
        <p className="title-name">안녕하세요. 저는 {member.name}입니다.</p>
        <p className="title-name">직업은 {member.job}입니다.</p>
        <p className="title-name">주소는 {member.addr}입니다.</p>
        <p className="title-name">성별은 {member.gender}입니다.</p>
        <div>{getGeeting(false)}</div>
      </div>
    </>
  );
}

export default App;
