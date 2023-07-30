-- 코드를 입력하세요
select m.member_name as member_name, r.review_text as review_text, to_char(r.review_date, 'YYYY-MM-DD') review_date
from (select member_id, rank() over(order by count(review_id) desc) rank
      from rest_review
      group by member_id) c, member_profile m, rest_review r
where c.rank = 1
and c.member_id = m.member_id
and m.member_id = r.member_id
order by review_date asc, review_text asc