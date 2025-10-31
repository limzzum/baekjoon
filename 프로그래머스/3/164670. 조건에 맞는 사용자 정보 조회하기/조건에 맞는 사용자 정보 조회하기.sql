-- 코드를 입력하세요



SELECT b.USER_ID, b.NICKNAME, concat(b.city," ", b.street_address1," ", b.street_address2) as '전체주소', concat(LEFT(b.tlno,3), "-", LEFT(RIGHT(b.tlno, 8),4),"-", RIGHT(b.tlno, 4)) as '전화번호'
from used_goods_board a join used_goods_user b
on a.writer_id = b.user_id
group by user_id                                                     
having count(*) >= 3
order by user_id desc;