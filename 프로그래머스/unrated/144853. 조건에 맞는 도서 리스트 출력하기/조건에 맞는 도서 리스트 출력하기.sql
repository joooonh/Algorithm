-- 코드를 입력하세요
select book_id, to_char(published_date, 'yyyy-mm-dd') as published_date
from book
where category = '인문'
and to_char(published_date, 'yyyy') = 2021
order by published_date