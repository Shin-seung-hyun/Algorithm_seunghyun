# 동물 보호소에 들어온 동물의 정보    ANIMAL_INS 
# 동물 보호소에서 입양 보낸 동물의 정보 ANIMAL_OUTS 

-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을
-- ID 순으로 조회

SELECT  OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_INS AS INS RIGHT JOIN ANIMAL_OUTS AS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL
ORDER BY OUTS.ANIMAL_ID;