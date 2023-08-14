-- 코드를 입력하세요
SELECT round(avg(daily_fee)) as average_fee
from car_rental_company_car
group by car_type
having car_type = 'SUV'
