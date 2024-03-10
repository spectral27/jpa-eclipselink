CREATE SEQUENCE public.department_id_seq;
CREATE SEQUENCE public.users_id_seq;

CREATE TABLE public.department (
	id int4 NOT NULL DEFAULT nextval('department_id_seq'::regclass),
	"name" varchar(255) NULL,
	CONSTRAINT department_pkey PRIMARY KEY (id)
);

CREATE TABLE public.users (
	id int4 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
	fullname varchar(255) NULL,
	department_id int4 NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

INSERT INTO public.department ("name") VALUES ('JPA');
INSERT INTO public.department ("name") VALUES ('EclipseLink');
INSERT INTO public.department ("name") VALUES ('PostgreSql');

INSERT INTO public.users (fullname, department_id) VALUES ('Adam Brown', 1);
INSERT INTO public.users (fullname, department_id) VALUES ('Byron Cole', 1);
INSERT INTO public.users (fullname, department_id) VALUES ('Colin Davidson', 2);
INSERT INTO public.users (fullname, department_id) VALUES ('Dylan Evans', 2);
INSERT INTO public.users (fullname, department_id) VALUES ('Elliott Foster', 3);
INSERT INTO public.users (fullname, department_id) VALUES ('Frank Green', 3);
