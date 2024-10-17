# Write your MySQL query statement below
select  p.product_name, S.year, S.price from Sales S left join Product P on S.product_id=P.product_id