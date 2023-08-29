-- 코드를 입력하세요
SELECT history_id, car_id, to_char(start_date, 'yyyy-mm-dd') as start_date, to_char(end_date, 'yyyy-mm-dd') as end_date, 
    case when to_date(end_date) - to_date(start_date) + 1 >= 30 then '장기 대여'
         else '단기 대여'
    end as rent_type
from car_rental_company_rental_history
where to_char(start_date, 'yyyy-mm') like '%2022-09%'
order by history_id desc