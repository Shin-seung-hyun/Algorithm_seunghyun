-- 코드를 입력하세요
# SELECT count( distinct name)
# from animal_ins;

select count( distinct name) as count
from animal_ins
where name is not null