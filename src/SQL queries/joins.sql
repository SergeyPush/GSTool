--select * from ACCESS_USER;
--select * from ACCESS_ROLE;
--select * from ACCESS_USER_ROLE;


-- Список пользователей и их ролей
--SELECT ACCESS_USER.ACCOUNTNAME, ACCESS_ROLE.NAME FROM ACCESS_USER
--FULL JOIN ACCESS_USER_ROLE
--ON ACCESS_USER.ID = ACCESS_USER_ROLE.USER_ID
--FULL JOIN ACCESS_ROLE
--ON ACCESS_USER_ROLE.ROLE_ID = ACCESS_ROLE.ID
--ORDER BY ACCESS_USER.ACCOUNTNAME;


-- Список ТО и их типов
--SELECT TARGET_OBJECT.NAME, TARGET_OBJECT_TYPE.LABEL_KEY FROM TARGET_OBJECT
--JOIN TARGET_OBJECT_TYPE
--ON TARGET_OBJECT.TARGET_OBJECT_TYPE_ID = TARGET_OBJECT_TYPE.ID
--WHERE TARGET_OBJECT.NAME LIKE '% room' AND TARGET_OBJECT_TYPE.SAFETY_CONCEPT_VERSION_ID=41;


-- Список сабтипов у типов
--SELECT TARGET_OBJECT.NAME, TARGET_OBJECT_TYPE.LABEL_KEY, HAS_SUBTYPE.TARGET_OBJECT_ID, TARGET_OBJECT_SUBTYPE.LABEL_KEY FROM TARGET_OBJECT
--JOIN TARGET_OBJECT_TYPE
--ON TARGET_OBJECT.TARGET_OBJECT_TYPE_ID = TARGET_OBJECT_TYPE.ID
--JOIN HAS_SUBTYPE
--ON TARGET_OBJECT.ID = HAS_SUBTYPE.TARGET_OBJECT_ID
--JOIN TARGET_OBJECT_SUBTYPE
--ON HAS_SUBTYPE.TARGET_OBJECT_SUBTYPE_ID = TARGET_OBJECT_SUBTYPE.ID
--WHERE TARGET_OBJECT.NAME LIKE '% room' AND TARGET_OBJECT_TYPE.SAFETY_CONCEPT_VERSION_ID=41 AND TARGET_OBJECT_SUBTYPE.SAFETY_CONCEPT_VERSION_ID = 41;


-- Кол-во сабтипов у типов
--SELECT TARGET_OBJECT.NAME, COUNT(TARGET_OBJECT_SUBTYPE.LABEL_KEY) FROM TARGET_OBJECT
--JOIN HAS_SUBTYPE
--ON TARGET_OBJECT.ID = HAS_SUBTYPE.TARGET_OBJECT_ID
--JOIN TARGET_OBJECT_SUBTYPE
--ON HAS_SUBTYPE.TARGET_OBJECT_SUBTYPE_ID = TARGET_OBJECT_SUBTYPE.ID
--WHERE TARGET_OBJECT.NAME LIKE '% room' AND TARGET_OBJECT_SUBTYPE.SAFETY_CONCEPT_VERSION_ID = 41
--GROUP BY TARGET_OBJECT.NAME;

-- Список модулей у сабтипов

SELECT TARGET_OBJECT.NAME, TARGET_OBJECT_SUBTYPE.LABEL_KEY, MODULE_SUBTYPE.MODULE_ID FROM TARGET_OBJECT
JOIN HAS_SUBTYPE
ON TARGET_OBJECT.ID = HAS_SUBTYPE.TARGET_OBJECT_ID
JOIN TARGET_OBJECT_SUBTYPE
ON HAS_SUBTYPE.TARGET_OBJECT_SUBTYPE_ID = TARGET_OBJECT_SUBTYPE.ID
JOIN MODULE_SUBTYPE
ON HAS_SUBTYPE.TARGET_OBJECT_SUBTYPE_ID = MODULE_SUBTYPE.SUBTYPE_ID
WHERE TARGET_OBJECT.NAME LIKE '% room' AND TARGET_OBJECT_SUBTYPE.SAFETY_CONCEPT_VERSION_ID = 41 AND MODULE_SUBTYPE.SAFETY_CONCEPT_VERSION_ID = 41;










