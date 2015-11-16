/* Formatted on 2015-10-29 오후 12:26:31 (QP5 v5.227.12220.39754) */
INSERT INTO defult_user (u_id, u_pw, u_nick)
     VALUES ('test', 'test', 'test');

INSERT INTO defult_board (b_title, b_content, u_no)
     VALUES ('test', 'test', 1);

INSERT INTO defult_reply (r_content, b_no, u_no)
     VALUES ('test', 1, 1);
     
INSERT INTO defult_user (u_id, u_pw, u_nick)
     VALUES ('test1', 'test1', 'test1');

INSERT INTO defult_board (b_title, b_content, u_no)
     VALUES ('test1', 'test1', 2);

INSERT INTO defult_reply (r_content, b_no, u_no)
     VALUES ('test1', 2, 2);
     
INSERT INTO defult_reply (r_content, b_no, u_no)
     VALUES ('test1', 1, 2);
     
INSERT INTO defult_reply (r_content, b_no, u_no)
     VALUES ('test1', 2, 1);
     
INSERT INTO defult_board (b_title, b_content, u_no,b_delete)
     VALUES ('test', 'test', 1,1);
     
INSERT INTO defult_reply (r_content, b_no, u_no,r_delete)
     VALUES ('test1', 1, 1,1);