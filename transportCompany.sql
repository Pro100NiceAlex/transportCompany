--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-08-19 05:10:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 214 (class 1259 OID 16445)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: user1
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO user1;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16451)
-- Name: transport; Type: TABLE; Schema: public; Owner: user1
--

CREATE TABLE public.transport (
    statenumber character varying(255) NOT NULL,
    brand character varying(255) NOT NULL,
    model character varying(255) NOT NULL,
    category character varying(255) NOT NULL,
    trailer boolean NOT NULL,
    yearrelease character varying(255) NOT NULL,
    vehicletype character varying(255) NOT NULL
);


ALTER TABLE public.transport OWNER TO user1;

--
-- TOC entry 3318 (class 0 OID 16451)
-- Dependencies: 215
-- Data for Name: transport; Type: TABLE DATA; Schema: public; Owner: user1
--

COPY public.transport (statenumber, brand, model, category, trailer, yearrelease, vehicletype) FROM stdin;
К234ЕМ	Kia	Optima	M1	f	2005	Легковой автомобиль общего назначения
М070ТТ	Kia	K2500D	N1	f	2012	Грузовой автомобиль общего назначения
У244РР	Lada	Granta	M1	f	2012	Легковой автомобиль общего назначения
Е222КК	Ferrari	F154 engine	M1	f	2015	Легковой автомобиль общего назначения
Х777ХХ	AURUS	Senat	M1	f	2021	Легковой автомобиль общего назначения
В453КС	Toyota	Fortune	M1	f	2011	Легковой автомобиль общего назначения
Х122АА	Datsun	on-DO	M1	f	2015	Легковой автомобиль общего назначения
К444НН	КАМАЗ	68902	N3	f	2011	Грузовой автомобиль общего назначения
Х333РС	КАМАЗ	61B0	N3	f	2011	Грузовой автомобиль общего назначения
С122УА	Honda	Accord	M1	f	2013	Легковой автомобиль общего назначения
С344КН	ПАЗ	3237-01	M3	f	2009	Автобус общего назначения
У965АА	Уamaha	YBR125	L3	f	2011	Прочее транспортное средство
C333CC	Jet	YL150-6	L3	f	2011	Прочее транспортное средство
Н363АА	Сталкер Туринг	7196	O2	t	2017	Прочее транспортное средство
Н243КК	ГИРД	5849D	N3	f	2020	Автомобиль-тягач
А111ББ	УАЗ	396254	M2	t	1994	Грузопассажирский автомобиль
А390ОХ	Volkswagen	Caravelle	M2	f	2011	Микроавтобус
\.


--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 214
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: user1
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3174 (class 2606 OID 16494)
-- Name: transport transport_pkey; Type: CONSTRAINT; Schema: public; Owner: user1
--

ALTER TABLE ONLY public.transport
    ADD CONSTRAINT transport_pkey PRIMARY KEY (statenumber);


-- Completed on 2023-08-19 05:10:02

--
-- PostgreSQL database dump complete
--

