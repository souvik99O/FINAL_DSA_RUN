# Write your MySQL query statement below
with ref as
(
select  a1.machine_id ,a1.process_id ,(a1.timestamp  - a2.timestamp ) as time 
from  Activity a1, Activity a2 where a1.machine_id=a2.machine_id and a1.process_id=a2.process_id and a1.activity_type = 'end' AND a2.activity_type = 'start'
order by machine_id
)
select machine_id, round(avg(time),3) as processing_time from ref group by machine_id;