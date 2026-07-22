# Write your MySQL query statement below
select t.player_id ,MIN(t.event_date) as first_login from Activity t group by t.player_id;