import { useParams } from "react-router-dom";
// useParams는 리액트 라우터에서 URL 파라미터 값을 가져오기 위한 훅

const data = {
    frontend: {
        name: "곰돌이",
        description: "리액트를 좋아하는 개발자"
    },
    backend: {
        name: "사육사",
        description: "스프링 부트를 좋아하는 개발자"
    },
};

const Profile = () => {
    const params = useParams();
    const profile = data[params.username];

    return(
        <div>
        <h1>사용자 프로필</h1>
        {profile ? ( <div>
                <h2>{profile.name}</h2>
                <p>{profile.description}`</p>
            </div>
            ) : (<p>존재하지 않는 프로필 입니다.</p>)
        }
        </div>
    );
};
export default Profile;