-- CAR_RENTAL_COMPANY_CAR               대여 중인 자동차들의 정보
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY    자동차 대여 기록 정보
-- CAR_RENTAL_COMPANY_DISCOUNT_PLAN     자동차 종류 별 대여 기간 종류 별 할인 정책 정보
 
# 조건
# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
# 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 
# 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE)
# 대여 금액을 기준으로 내림차순, 자동차 종류를 기준으로 오름차순 및 자동차 ID를 기준으로 내림차순 정렬

SELECT DISTINCT HISTORY.CAR_ID,
                CAR.CAR_TYPE,
                ROUND((CAR.DAILY_FEE * (100 - PLAN.DISCOUNT_RATE) / 100) * 30) AS FEE
        
FROM    CAR_RENTAL_COMPANY_CAR AS CAR
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS HISTORY ON CAR.CAR_ID = HISTORY.CAR_ID
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN ON CAR.CAR_TYPE = PLAN.CAR_TYPE

WHERE   CAR.CAR_TYPE IN ('세단', 'SUV') AND
        HISTORY.CAR_ID NOT IN(
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
        ) AND 
        DURATION_TYPE = '30일 이상' AND
        ROUND((CAR.DAILY_FEE * (100 - PLAN.DISCOUNT_RATE) / 100) * 30) BETWEEN 500000 AND 2000000
        
ORDER BY FEE DESC, CAR.CAR_TYPE ASC, HISTORY.CAR_ID DESC;
        