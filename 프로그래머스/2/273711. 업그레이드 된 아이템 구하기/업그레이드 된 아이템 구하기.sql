# SELECT ITEM_ID, ITEM_NAME, RARITY
# FROM ITEM_INFO
# WHERE ITEM_ID IN (
#     SELECT TREE.ITEM_ID
#     FROM ITEM_INFO AS INFO JOIN ITEM_TREE AS TREE ON INFO.ITEM_ID = TREE.PARENT_ITEM_ID
#     WHERE RARITY = 'RARE' 
#     )
# ORDER BY ITEM_ID DESC;  


SELECT II.ITEM_ID, II.ITEM_NAME, II.RARITY
FROM ITEM_INFO AS II JOIN ITEM_TREE AS IT ON II.ITEM_ID = IT.ITEM_ID
WHERE IT.PARENT_ITEM_ID IN (
    SELECT ITEM_ID
    FROM ITEM_INFO
    WHERE RARITY = 'RARE'
)
ORDER BY II.ITEM_ID DESC;
