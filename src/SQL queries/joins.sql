--select * from ACCESS_USER;
--select * from ACCESS_ROLE;
--
--select * from ACCESS_USER_ROLE;


-- Список пользователей и их ролей
select ACCESS_USER.ACCOUNTNAME, ACCESS_ROLE.NAME from ACCESS_USER
full join ACCESS_USER_ROLE
on ACCESS_USER.ID = ACCESS_USER_ROLE.USER_ID
full join ACCESS_ROLE
on ACCESS_USER_ROLE.ROLE_ID = ACCESS_ROLE.ID;