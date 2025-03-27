-- 코드를 작성해주세요
select DISTINCT(D.ID), D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS AS D
JOIN SKILLCODES AS S ON D.SKILL_CODE & S.CODE
WHERE S.NAME='Python' or S.NAME='C#'
ORDER  BY D.ID ASC;