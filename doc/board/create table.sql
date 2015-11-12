
CREATE TABLE defult_board
(
	b_no                 INTEGER NOT NULL ,
	b_title              VARCHAR2(1000) NOT NULL ,
	b_content            VARCHAR2(4000) NOT NULL ,
	b_indate             DATE DEFAULT  sysdate  NOT NULL ,
	b_eddate             DATE DEFAULT  sysdate  NOT NULL ,
	b_delete             NUMBER(1) DEFAULT  0  NOT NULL ,
	u_no                 INTEGER NOT NULL 
);



CREATE UNIQUE INDEX XPK게시판 ON defult_board
(b_no   ASC);



ALTER TABLE defult_board
	ADD CONSTRAINT  XPK게시판 PRIMARY KEY (b_no);



CREATE TABLE defult_reply
(
	r_no                 INTEGER NOT NULL ,
	r_content            VARCHAR2(1000) NOT NULL ,
	r_indate             DATE DEFAULT  sysdate  NOT NULL ,
	r_eddate             DATE DEFAULT  sysdate  NOT NULL ,
	r_delete             NUMBER(1) DEFAULT  0  NOT NULL ,
	u_no                 INTEGER NOT NULL ,
	b_no                 INTEGER NOT NULL 
);



CREATE UNIQUE INDEX XPK덧글 ON defult_reply
(r_no   ASC);



ALTER TABLE defult_reply
	ADD CONSTRAINT  XPK덧글 PRIMARY KEY (r_no);



CREATE TABLE defult_user
(
	u_no                 INTEGER NOT NULL ,
	u_id                 VARCHAR2(20) NOT NULL ,
	u_pw                 VARCHAR2(100) NOT NULL ,
	u_nick               VARCHAR2(20) NOT NULL ,
	u_indate             DATE DEFAULT  sysdate  NOT NULL ,
	u_delete             NUMBER(1) DEFAULT  0  NOT NULL ,
	u_eddate             DATE DEFAULT  sysdate  NOT NULL 
);



CREATE UNIQUE INDEX XPK회원 ON defult_user
(u_no   ASC);



ALTER TABLE defult_user
	ADD CONSTRAINT  XPK회원 PRIMARY KEY (u_no);



CREATE UNIQUE INDEX u_id_uK ON defult_user
(u_id   ASC);



ALTER TABLE defult_user
ADD CONSTRAINT  u_id_uK UNIQUE (u_id);



CREATE UNIQUE INDEX u_nick_uk ON defult_user
(u_nick   ASC);



ALTER TABLE defult_user
ADD CONSTRAINT  u_nick_uk UNIQUE (u_nick);



ALTER TABLE defult_board
	ADD (CONSTRAINT R_5 FOREIGN KEY (u_no) REFERENCES defult_user (u_no));



ALTER TABLE defult_reply
	ADD (CONSTRAINT R_6 FOREIGN KEY (u_no) REFERENCES defult_user (u_no));



ALTER TABLE defult_reply
	ADD (CONSTRAINT R_7 FOREIGN KEY (b_no) REFERENCES defult_board (b_no));


CREATE TABLE defult_file
(
	b_no                 INTEGER NOT NULL ,
	f_no                 INTEGER NOT NULL ,
	f_onm                VARCHAR2(260) NOT NULL ,
	f_rnm                VARCHAR2(100) NOT NULL ,
	f_sz                 INTEGER NOT NULL ,
	f_indate             DATE DEFAULT  sysdate  NOT NULL ,
	f_delete             NUMBER(1) DEFAULT  0  NOT NULL 
);

CREATE UNIQUE INDEX XPK게시판_파일 ON defult_file
(f_no   ASC);

ALTER TABLE defult_file
	ADD CONSTRAINT  XPK게시판_파일 PRIMARY KEY (f_no);
  
  ALTER TABLE defult_file
	ADD (CONSTRAINT R_8 FOREIGN KEY (b_no) REFERENCES defult_board (b_no));