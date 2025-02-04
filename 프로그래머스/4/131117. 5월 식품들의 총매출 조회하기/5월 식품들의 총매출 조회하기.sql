SELECT FO.PRODUCT_ID, FP.PRODUCT_NAME, SUM(FO.AMOUNT) * FP.PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT FP JOIN FOOD_ORDER FO ON FP.PRODUCT_ID = FO.PRODUCT_ID
WHERE DATE_FORMAT(FO.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY FO.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, FO.PRODUCT_ID;