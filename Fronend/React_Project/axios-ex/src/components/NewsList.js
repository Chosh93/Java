import styled from "styled-components";
import NewsItem from "./NewsItem";
import { useState, useEffect } from 'react';
import axios from "axios";


const NewsListBlock = styled.div`
box-sizing: border-box;
padding-bottom: 3em;
width: 768px;
margin: 0 auto;
margin-top: 2rem;
@media screen and (max-width: 768px) {
    width: 100%;
    padding-left: 1em;
    padding-right: 1em;
}
`;

const NewsList = (props) => {
    const [articles, setArticles] = useState(null);
    const [loading, setLoading] = useState(false);
// 로딩바
    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                console.log(articles);
                const query = props.category === "all" ? "all" : `category=${props.category}`;
                const response = await axios.get(
                    `https://newsapi.org/v2/top-headlines?country=kr&${query}&apiKey=ffbbc82f694941a7b0e2d4f4515abcc7`);
                setArticles(response.data.articles);
            } catch (e) {
                console.log(e);
            }
            setLoading(false);
        };
        fetchData();
    }, [props.category]);

		// 대기 중일 때
    if(loading) {
        return <NewsListBlock>로딩중...</NewsListBlock>
    }
    // if(!articles) return null;

    return(
        <NewsListBlock>
            {articles && articles.map(article => (
                <NewsItem key={article.url} article={article} />
            ))}
        </NewsListBlock>
    );
}
export default NewsList;