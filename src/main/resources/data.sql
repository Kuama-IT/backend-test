CREATE TABLE REQUEST_DATA(
ID BIGINT PRIMARY KEY AUTO_INCREMENT,
REQUEST_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
REQUEST_NAME VARCHAR2(500) NOT NULL,
RESPONSE_BODY CLOB
);