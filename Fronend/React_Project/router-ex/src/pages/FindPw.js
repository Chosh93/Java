import React from "react";
import { Link } from "react-router-dom";


const FindPw = () => {
    return (
        <>
        <h1>패스워드 찾기 페이지 입니다.</h1>
        <p>아이디: <br />이름: <br />이메일:</p>
        <br />
        <Link to="/login">로그인</Link>
        </>
    );
};

export default FindPw;