-- DB 생성
CREATE DATABASE IF NOT EXISTS mybatisdb
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE mybatisdb;

-- 테이블
DROP TABLE IF EXISTS board;
CREATE TABLE board (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(200) NOT NULL,
                       content TEXT NOT NULL,
                       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO board (title, content)
VALUES
    ('공지사항', '사이트가 오픈되었습니다. 많은 이용 바랍니다.'),
    ('자유게시판 테스트', '여기는 자유롭게 글을 쓸 수 있는 공간입니다.'),
    ('Q&A 첫 글', '궁금한 점을 남겨주시면 답변드리겠습니다.');