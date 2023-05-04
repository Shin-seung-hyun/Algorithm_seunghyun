# 중고거래 게시판 정보 USED_GOODS_BOARD
# 중고거래 게시판 첨부파일 정보 USED_GOODS_FILE

-- 조회수가 가장 높은 게시물에 대한 첨부파일 경로 조회
-- FILE ID 기준 내림차순


SELECT CONCAT('/home/grep/src/', FILE.BOARD_ID , '/' ,FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE AS FILE JOIN USED_GOODS_BOARD AS BOARD ON FILE.BOARD_ID = BOARD.BOARD_ID
WHERE VIEWS LIKE 
(
    SELECT MAX(VIEWS) 
    FROM USED_GOODS_BOARD
)
ORDER BY FILE_ID DESC;
