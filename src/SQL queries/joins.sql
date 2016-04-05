--select * from ACCESS_USER;
--select * from ACCESS_ROLE;
--
--select * from ACCESS_USER_ROLE;


-- Список пользователей и их ролей
--select ACCESS_USER.ACCOUNTNAME, ACCESS_ROLE.NAME from ACCESS_USER
--full join ACCESS_USER_ROLE
--on ACCESS_USER.ID = ACCESS_USER_ROLE.USER_ID
--full join ACCESS_ROLE
--on ACCESS_USER_ROLE.ROLE_ID = ACCESS_ROLE.ID;

-- Список ТО и их типов
SELECT TARGET_OBJECT.NAME, TARGET_OBJECT_SUBTYPE.SAFETY_CONCEPT_VERSION_ID FROM TARGET_OBJECT
inner JOIN TARGET_OBJECT_SUBTYPE
ON TARGET_OBJECT.TARGET_OBJECT_TYPE_ID = TARGET_OBJECT_SUBTYPE.TARGET_OBJECT_TYPE_ID;




