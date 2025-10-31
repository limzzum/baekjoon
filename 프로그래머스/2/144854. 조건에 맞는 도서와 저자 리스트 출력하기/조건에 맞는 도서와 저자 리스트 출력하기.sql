-- 코드를 입력하세요
SELECT b.book_id as BOOK_ID, a.author_name as AUTHOR_NAME, DATE_FORMAT(b.published_date, "%Y-%m-%d") as PUBLISHED_DATE
from book b join author a
using (author_id)
where b.category = '경제'
order by published_date asc;