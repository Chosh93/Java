import logo from './logo.svg';
import './App.css';
import Home from './pages/Home';
import About from './pages/About';
import Login from './pages/Login';
import Member from './pages/Member';
import FindId from './pages/FindId';
import FindPw from './pages/FindPw';
import Profile from './pages/Profile';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

// <Route path="주소 규칙" element={보여 줄 컴포넌트 jsx}/>


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/About" element={<About/>}/>
        <Route path="/Login" element={<Login/>}/>
        <Route path="/Member" element={<Member/>}></Route>
        <Route path="/FindId" element={<FindId/>}></Route>
        <Route path="/FindPw" element={<FindPw/>}></Route>
        <Route path="/Profile/:username" element={<Profile/>}></Route>
      </Routes>
    </Router>
  );
}

export default App;
