import './App.css';
import Section  from './컴포넌트합성';
import MyComponent from './MyComponent';
import Person from './Person';
import Say from './Say';
import Clock from './Clock';


// 컴포넌트는 항상 대문자로 시작하고, 반환값으로 UI요소를 반환
// function WelcomeProps(props){
//   return <h1>Hello, {props.name} {props.age}</h1>
// }

// function App(){
const App = () => {
  let insideTag = "운동";
  const personData = {
    name : "원숭이",
    age : 18,
    gender : "수컷"
  };

  return(
    <>
    {/* <WelcomeProps name="곰돌이" age="20"/>
    <WelcomeProps name="호랑이" age="21"/>
    <WelcomeProps name="강아지" age="21"/> */}
    <Section title="test" content="react"/>
    <Section title="test2" content="react2"/>
    <MyComponent name="호랑이">{insideTag}</MyComponent>
    <Person {...personData}/>
    <Say/>
    <Clock/>
    </>
  );
}

export default App;
