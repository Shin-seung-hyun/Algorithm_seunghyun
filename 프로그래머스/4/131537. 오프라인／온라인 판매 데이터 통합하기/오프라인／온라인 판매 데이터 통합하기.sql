(select to_char(sales_date, 'yyyy-mm-dd') as sales_date, product_id, user_id, sales_amount
from online_sale
where to_char(sales_date,'yyyy-mm') = '2022-03')

union

(select to_char(sales_date, 'yyyy-mm-dd') as sales_date, product_id, null as user_id , sales_amount
from offline_sale
where to_char(sales_date,'yyyy-mm') = '2022-03');