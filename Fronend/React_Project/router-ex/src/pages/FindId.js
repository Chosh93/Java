import React from "react";
import { Link } from "react-router-dom";

const FindId = () => {
    return (
        <>
        <h1>아이디 찾기 페이지 입니다.</h1>
        <p>이름: <br />이메일:</p>
        <br />
        <Link to="/login">로그인</Link> <br />
        <Link to="/findpw">비밀번호 찾기</Link>

        </>
    );
};

export default FindId;