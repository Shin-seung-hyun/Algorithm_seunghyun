-- 아이스크림 가게의 상반기 주문 정보     FIRST_HALF
-- 7월의 아이스크림 주문 정보            JULY

# 7월 아이스크림 총 주문량 + 상반기의 아이스크림 총 주문량의 상위 3개의 맛
SELECT FLAVOR
FROM (  SELECT *
        FROM FIRST_HALF

        UNION ALL

        SELECT *
        FROM JULY
     ) AS A
GROUP BY A.FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;
