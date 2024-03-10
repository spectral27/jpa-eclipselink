CREATE SEQUENCE public.scope_id_seq;
CREATE SEQUENCE public.version_id_seq;

CREATE TABLE public.scope (
	id int4 NOT NULL DEFAULT nextval('scope_id_seq'::regclass),
	"name" varchar(255) NULL,
	CONSTRAINT scope_pkey PRIMARY KEY (id)
);

CREATE TABLE public.version (
    id int4 NOT NULL DEFAULT nextval('version_id_seq'::regclass),
    version varchar(255) NULL,
    released date NULL,
    scope_id int4 NULL,
    CONSTRAINT version_pkey PRIMARY KEY (id)
);

INSERT INTO public.scope ("name") VALUES ('JPA');
INSERT INTO public.scope ("name") VALUES ('Hibernate');

INSERT INTO public.version (version, released, scope_id) VALUES ('3.1.0', '2023-03-30', 1);
INSERT INTO public.version (version, released, scope_id) VALUES ('6.4.4', '2024-02-22', 2);
