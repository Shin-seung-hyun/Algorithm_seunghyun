SELECT animal_id, name
from animal_ins
where INTAKE_CONDITION = 'sick'
order by animal_id asc;