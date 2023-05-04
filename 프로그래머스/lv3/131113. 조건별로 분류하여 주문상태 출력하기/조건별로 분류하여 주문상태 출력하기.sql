-- 5/1을 기준으로 조회
-- 출고 여부는 5/1까지 출고 완료, 이후는 출고 대기로, 미정이면 출고 미정으로 입력
-- 주문 ID를 ASC;

SELECT  ORDER_ID, 
        PRODUCT_ID, 
        DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
        CASE
            WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
            WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
            ELSE '출고미정'
        END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID;