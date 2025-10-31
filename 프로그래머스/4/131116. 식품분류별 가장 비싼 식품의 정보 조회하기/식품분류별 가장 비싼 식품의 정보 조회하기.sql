-- 코드를 입력하세요
# select * from food_product

SELECT CATEGORY, MAX(PRICE) as MAX_PRICE, (select product_name from food_product where price = MAX(a.PRICE) and category = a.category) as PRODUCT_NAME
from food_product a
group by category
having category in ("과자", "국", "김치", "식용유")
order by price desc;