-- 코드를 작성해주세요
WITH RANKDATA AS(
    SELECT ID, NTILE(4) OVER(ORDER BY SIZE_OF_COLONY) AS COLONY_NAME
    FROM ECOLI_DATA
    ORDER BY ID
)
SELECT ID, CASE WHEN COLONY_NAME=1 THEN 'LOW'
            WHEN COLONY_NAME=2 THEN 'MEDIUM'
            WHEN COLONY_NAME=3 THEN 'HIGH'
            ELSE 'CRITICAL' END AS COLONY_NAME
FROM RANKDATA