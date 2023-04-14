import React, { useState } from "react";
// 이름, 직책, 회사명, 회사주소, 이메일, 전화번호를 입력 받아 명함 형태로 출력하기
// 명함 정보 저장을 위한 객체리터럴 생성
// 입력 받은 후 제출 버튼을 누르기 전까지는 화면에 출력이 되지 않아야 함함


 const NameCard = ({member}) => {
    return (
        <>
        <h3>명함 정보 출력</h3>
        <p>이름 : {member.name}</p>
        <p>직책 : {member.position}</p>
        <p>회사 : {member.company}</p>
        <p>주소 : {member.addr}</p>
        <p>메일 : {member.eMail}</p>
        <p>전화 : {member.phone}</p>
        </>
    );
 };

 const UserState = () => {
    const [member, setMember] = useState({name:"", position:"", company:"", addr:"", eMail:"", phone:""});
    const [submit, setSubmit] = useState(false);
    const onChangeName = (e) => setMember({...member, name: e.target.value});
    const onChangePos = (e) => setMember({...member, position: e.target.value});
    const onChangeCom = (e) => setMember({...member, company: e.target.value});
    const onChangeAddr = (e) => setMember({...member, addr: e.target.value});
    const onChangeMail = (e) => setMember({...member, eMail: e.target.value});
    const onChangePhone = (e) => setMember({...member, phone: e.target.value});

    const onSubmit = () => {
        setSubmit(true);
    }
    return (
        <>
        <h1>회원 정보</h1>
        <input type="text" placeholder="이름 입력" value={member.name} onChange={onChangeName}/>
        <br />
        <input type="text" placeholder="직책 입력" value={member.position} onChange={onChangePos}/>
        <br />
        <input type="text" placeholder="회사 입력" value={member.company} onChange={onChangeCom}/>
        <br />
        <input type="text" placeholder="주소 입력" value={member.addr} onChange={onChangeAddr}/>
        <br />
        <input type="text" placeholder="메일 입력" value={member.eMail} onChange={onChangeMail}/>
        <br />
        <input type="text" placeholder="휴대폰 번호 입력" value={member.phone} onChange={onChangePhone}/>
        <br />
        <button onClick={onSubmit}>제출</button>
        {submit && <NameCard member={member}/>}
        </>
    );
 };
 export default UserState;