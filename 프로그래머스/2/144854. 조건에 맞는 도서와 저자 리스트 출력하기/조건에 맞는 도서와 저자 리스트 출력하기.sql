SELECT
    BOOK_ID,
    A.AUTHOR_NAME,
    DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK B JOIN AUTHOR A USING(AUTHOR_ID)
WHERE B.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE