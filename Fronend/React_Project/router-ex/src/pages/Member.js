import React from "react";
import { Link } from "react-router-dom";
const Member = () => {
    return (
        <>
        <h1>회원가입 페이지</h1>
        <p>아이디: </p>
        <p>비밀번호: </p>
        <p>이름: </p>
        <p>전화번호: </p>
        <br />
        <Link to="/login">회원가입</Link>
        </>
    );
};

export default Member;