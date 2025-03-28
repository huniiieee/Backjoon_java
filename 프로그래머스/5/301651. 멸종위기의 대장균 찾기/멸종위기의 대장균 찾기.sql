-- 코드를 작성해주세요
WITH RECURSIVE GEN AS(
    SELECT ID, PARENT_ID,1 AS GENERATION
    FROM ECOLI_DATA 
    WHERE PARENT_ID IS NULL
    UNION
    SELECT E.ID, E.PARENT_ID, GENERATION+1
    FROM ECOLI_DATA AS E
    JOIN GEN AS G ON E.PARENT_ID=G.ID
)
SELECT COUNT(*) AS COUNT, GENERATION
FROM GEN
WHERE ID NOT IN (SELECT PARENT_ID FROM GEN WHERE PARENT_ID IS NOT NULL)
GROUP BY GENERATION
ORDER BY GENERATION ASC;