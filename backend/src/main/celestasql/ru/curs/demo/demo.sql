CREATE SCHEMA testgrain VERSION '1.0';

create table street4(
/**
 {"width": 270, "caption": "Название"}
 */
	name varchar(40) NOT NULL,

/**
 {"cssStyle": "white-space:nowrap;width:100px;text-align:right;"}
 */
    rnum int NOT NULL,

	code varchar(17) NOT NULL PRIMARY KEY,

	socr varchar(10) NOT NULL,

	gninmb varchar(4) NOT NULL,

/**
 {"visible": false}
 */
	uno varchar(4) NOT NULL,
	ocatd varchar(11) NOT NULL
);



create index ix_street4 on street4 (name);

create index ix_street41 on street4 (name, gninmb, code);

create index ix_street42 on street4 (gninmb, code);

create index ix_street43 on street4 (name, gninmb);

create index ix_street44 on street4 (ocatd);

create index ix_street45 on street4 (rnum);

create index ix_street46 on street4 (name, code);

create index ix_street47 on street4 (rnum, code);



create table websitesVue (
/**
 {"cssClassName": "websitesvue-code"}
 */
code int not null primary key,

/**
 {"cssClassName": "websitesvue-name"}
 */
Name varchar(64) NOT NULL,

/**
 {"cssClassName": "websitesvue-picture"}
 */
Picture varchar(255)  NULL,

/**
 {"cssClassName": "websitesvue-file1"}
 */
File1 varchar(255) NULL,

/**
 {"cssClassName": "websitesvue-logo"}
 */
Logo varchar(255)  NULL,

/**
 {"cssClassName": "websitesvue-file2"}
 */
File2 varchar(255) NULL,

/**
 {"cssClassName": "websitesvue-url"}
 */
Url varchar(255)  NULL
);


