with ref as
(SELECT 
    s.*,
    sub.*
FROM 
    Students s,
    Subjects sub
   )

   select 

   r.student_id,
   r.student_name,
   r.subject_name,
   count(e.subject_name) as attended_exams 

   from ref r
   left join 
   Examinations e
   on r.student_id=e.student_id and r.subject_name=e.subject_name
   group by r.student_id, r.student_name, r.subject_name
   order by r.student_id , r.subject_name;
   
