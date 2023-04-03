
SELECT animal_type, ifnull(name, 'No name') as NAME, SEX_UPON_INTAKE
from animal_ins
order by animal_id asc;