-- Write your PostgreSQL query statement below
SELECT w1.id
FROM Weather w1, Weather w2
where w1.recordDate-1=w2.recordDate
and w1.temperature > w2.temperature;
