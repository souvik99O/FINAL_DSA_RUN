# Write your MySQL query statement below
SELECT w1.id
FROM Weather w1, Weather w2
where dateDiff(w1.recordDate,w2.recordDate)=1
and w1.temperature > w2.temperature;

-- SELECT w1.Id
-- FROM Weather w1, Weather w2
-- WHERE dateDiff(w1.recordDate,w2.recordDate) = 1 AND w1.Temperature > w2.Temperature;