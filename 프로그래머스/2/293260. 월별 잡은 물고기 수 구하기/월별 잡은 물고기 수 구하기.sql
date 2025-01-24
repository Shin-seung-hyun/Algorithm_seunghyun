select count(*) FISH_COUNT, MONTH(TIME) MONTH
from fish_info
group by month(time)
order by month(time);
