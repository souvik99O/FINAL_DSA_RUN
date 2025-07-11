# Write your MySQL query statement below
-- select customer_id,count(customer_id) as count_no_trans 
-- from Visits where visit_id not in
-- (select distinct v.visit_id from Visits v inner join Transactions t  
-- on v.visit_id=t.visit_id)
-- group by customer_id;

select v.customer_id , count(customer_id) as count_no_trans  
from  Visits v left join Transactions t 
on v.visit_id=t.visit_id 
where transaction_id is null 
group by v.customer_id;



