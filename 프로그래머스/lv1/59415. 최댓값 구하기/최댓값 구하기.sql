-- 코드를 입력하세요
SELECT datetime
from (select *
     from animal_ins
     order by datetime desc)
where rownum = 1

 