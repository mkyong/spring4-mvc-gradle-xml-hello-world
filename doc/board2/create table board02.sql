create table board02(
  seq       varchar2(1000),
  name      varchar2(20) not null,
  passwd    varchar2(20) not null,
  title     varchar2(500)not null,
  content   clob         not null,
  filename  varchar2(100)not null,
  regdate   date         default sysdate,
  readcount number(10)   default 0,
  reply       varchar2(1000) not null,
  reply_step  number(10) default 0,
  reply_level number(10) default 0,

  constraint b_seq_pk primary key(seq)
);

create sequence sequence_board_seq
start with 1 increment by 1;
