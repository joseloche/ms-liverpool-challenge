DROP TABLE IF EXISTS folios;
create table folios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    folio varchar(50),
    digest varchar(50),
    primary key(id)
 ); 