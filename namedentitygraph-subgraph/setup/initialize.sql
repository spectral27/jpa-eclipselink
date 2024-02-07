CREATE SEQUENCE public.department_id_seq;
CREATE SEQUENCE public.users_id_seq;
CREATE SEQUENCE public.device_id_seq;

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

CREATE TABLE public.device (
    id int4 NOT NULL DEFAULT nextval('device_id_seq'::regclass),
    brand varchar(255) NULL,
    model varchar(255) NULL,
    user_id int4 NULL,
    CONSTRAINT device_pkey PRIMARY KEY (id)
);

INSERT INTO public.department ("name") VALUES ('JPA');
INSERT INTO public.department ("name") VALUES ('EclipseLink');

INSERT INTO public.users (fullname, department_id) VALUES ('Adam Brown', 1);
INSERT INTO public.users (fullname, department_id) VALUES ('Byron Cole', 2);

INSERT INTO public.device (brand, model, user_id) VALUES ('Dell', 'Notebook', 1);
INSERT INTO public.device (brand, model, user_id) VALUES ('Lenovo', 'Notebook', 2);
