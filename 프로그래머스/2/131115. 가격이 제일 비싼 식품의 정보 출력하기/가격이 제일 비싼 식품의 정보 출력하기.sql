-- 코드를 입력하세요
# SELECT *
# FROM FOOD_PRODUCT
# WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT );

select *
from food_product
order by price desc
limit 1;