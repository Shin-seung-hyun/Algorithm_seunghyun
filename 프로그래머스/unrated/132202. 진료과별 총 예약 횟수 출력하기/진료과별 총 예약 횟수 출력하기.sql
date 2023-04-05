-- 코드를 입력하세요
SELECT MCDP_CD as "진료과 코드", count(PT_NO) as "5월예약건수"
from appointment
where date_format(APNT_YMD, '%Y-%m') like '2022-05'
group by MCDP_CD
order by count(PT_NO) asc, MCDP_CD asc;