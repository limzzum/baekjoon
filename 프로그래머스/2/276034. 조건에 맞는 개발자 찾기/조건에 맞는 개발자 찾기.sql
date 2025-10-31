-- 코드를 작성해주세요

select ID, EMAIL, FIRST_NAME, LAST_NAME
from developers
where SKILL_CODE & (select sum(code) from skillcodes where name in ("Python", "C#")) > 0
order by id asc