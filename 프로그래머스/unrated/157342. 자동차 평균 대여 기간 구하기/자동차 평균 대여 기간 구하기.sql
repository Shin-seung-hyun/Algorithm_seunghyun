-- 평균 대여 기간이 7일 이상인 자동차들의 자동차 ID와 평균 대여 기간 출력
-- 평균 대여 기간은 두째자리에서 반올림
-- 평균 대여 기간 Desc, 자동차 ID desc;

# 날짜 차이 가져오기 DATEDIFF(날짜1, 날짜2)
# 반올림 ROUND
# 올림 CEIL
# 버림 FLOOR
# 자릿수 버림 TRUNCAT

SELECT  CAR_ID,
        ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;