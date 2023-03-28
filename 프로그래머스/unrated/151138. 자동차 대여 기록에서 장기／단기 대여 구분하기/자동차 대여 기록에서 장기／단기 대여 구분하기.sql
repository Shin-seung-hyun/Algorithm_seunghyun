/*
오늘 대여하고 오늘 반납해도 대여 기간은 하루이기 때문에 +1 필요

    2023년 1월 18일 대여  >>  2023년 1월 18일 반납  :  1일
    = (18일 - 18일) + 1일
    = 1일
*/
SELECT  HISTORY_ID,
        CAR_ID,
        DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
        DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
        CASE
            WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30
            -- WHEN END_DATE - START_DATE +1 >= 30 
                THEN '장기 대여'
                ELSE '단기 대여'
        END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m') LIKE '2022-09'
ORDER BY HISTORY_ID DESC;