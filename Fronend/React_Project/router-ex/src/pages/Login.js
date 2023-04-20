import React from "react";
import { Link } from "react-router-dom";

const Login = () => {

    return (
        <>
        <h1>로그인 페이지 입니다.</h1>
        <p>아이디 : <br />비밀번호 :</p>
        <br />
        <Link to="/">이전, 로그인</Link>
        <br />
        <Link to="/member">회원가입</Link>
        <br />
        <Link to="/findid">아이디/비밀번호 찾기</Link>
        </>
    );
};

export default Login;