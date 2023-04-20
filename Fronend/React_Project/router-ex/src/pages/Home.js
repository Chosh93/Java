import React from "react";
import { Link, useNavigate, Navigate } from "react-router-dom";
const Home = () => {
    const nav = useNavigate();
    const isLogin = false;
    if(!isLogin){
        return <Navigate to="/Login" replace={true}/>;
    }
    return (
        <>
        <h1>여기는 홈 입니다.</h1>
        <p>가장 먼저 보이는 페이지 입니다.</p>
        <Link to="/about">소개</Link>
        <br />
        <Link to="/login">로그인</Link>
        <br />
        <p onClick={() => nav("/about")}>소개페이지로 이동 합니다.</p>
        <ul>
            <li>
                <Link to="/profile/frontend">프론트엔드 프로필</Link>
            </li>
            <li>
                <Link to="/profile/backend">백엔드 프로필</Link>
            </li>
        </ul>
        </>
    );
};
export default Home;