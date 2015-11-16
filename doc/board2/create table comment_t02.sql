create table comment_t02(
  comment_seq  varchar2(1000),
  comment_name varchar2(20)   not null,
  comment_comm varchar2(4000) not null,
  seq          varchar2(1000) not null,
  
  constraint comment_t_comment_seq_pk primary key(comment_seq),
  constraint comment_t_seq_fk foreign key(seq) references board02(seq)
);

create sequence sequence_comment_seq
start with 1 increment by 1;