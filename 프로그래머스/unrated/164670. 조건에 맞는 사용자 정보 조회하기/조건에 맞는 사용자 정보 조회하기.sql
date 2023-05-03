
# 중고 거래 게시판 정보를 담은 USED_GOODS_BOARD
# 중고 거래 게시판 첨부파일 정보를 담은 USED_GOODS_FILE

-- 중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회 
-- 회원 ID를 기준으로 내림차순

# CONCAT 함수는 둘 이상의 문자열을 순서대로 합쳐줌
# LEFT(문자, 가져올 갯수)
# MID(문자, 시작 위치, 가져올 갯수) = SUBSTRING(문자, 시작 위치, 가져올 갯수)
# RIGHT(문자, 가져올 갯수)

SELECT  USER_ID,
        NICKNAME,
        CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2 ) AS 전체주소,
        CONCAT(LEFT(TLNO,3), '-', SUBSTRING(TLNO,4,4), '-', RIGHT(TLNO,4)) AS 전화번호
        
FROM USED_GOODS_BOARD AS BOARD JOIN USED_GOODS_USER AS USER ON BOARD.WRITER_ID = USER.USER_ID
GROUP BY USER.USER_ID
HAVING COUNT(USER_ID) >=3
ORDER BY USER.USER_ID DESC;