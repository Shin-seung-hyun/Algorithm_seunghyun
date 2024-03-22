
select member_id, member_name, gender, to_char(date_of_birth, 'yyyy-mm-dd') as date_of_birth
from member_profile
where to_char(date_of_birth, 'mm') = '03'
and tlno is not null
and gender = 'W'
order by member_id asc;
