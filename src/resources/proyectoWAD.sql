--
-- PostgreSQL database dump
--

-- Dumped from database version 11.13
-- Dumped by pg_dump version 11.13

-- Started on 2021-12-29 20:33:50

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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16587)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    idadmin character varying(15) NOT NULL,
    passadmin character varying(18) NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16563)
-- Name: calificacionesfinales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calificacionesfinales (
    idcalfinal integer NOT NULL,
    idestudiante integer NOT NULL,
    idcurso character varying(10) NOT NULL,
    calf integer NOT NULL
);


ALTER TABLE public.calificacionesfinales OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16561)
-- Name: calificacionesfinales_idcalfinal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.calificacionesfinales_idcalfinal_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.calificacionesfinales_idcalfinal_seq OWNER TO postgres;

--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 201
-- Name: calificacionesfinales_idcalfinal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.calificacionesfinales_idcalfinal_seq OWNED BY public.calificacionesfinales.idcalfinal;


--
-- TOC entry 204 (class 1259 OID 16581)
-- Name: calificacionesparciales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calificacionesparciales (
    llave_califi integer NOT NULL,
    descripcion character varying(30) NOT NULL
);


ALTER TABLE public.calificacionesparciales OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16579)
-- Name: calificacionesparciales_llave_califi_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.calificacionesparciales_llave_califi_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.calificacionesparciales_llave_califi_seq OWNER TO postgres;

--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 203
-- Name: calificacionesparciales_llave_califi_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.calificacionesparciales_llave_califi_seq OWNED BY public.calificacionesparciales.llave_califi;


--
-- TOC entry 200 (class 1259 OID 16551)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    idcurso character varying(10) NOT NULL,
    nombrecurso character varying(30) NOT NULL,
    descripcion character varying(200) NOT NULL,
    idprofesor integer NOT NULL
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16612)
-- Name: direccioncurso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.direccioncurso (
    iddir integer NOT NULL,
    idcurso character varying(10) NOT NULL,
    idprofesor integer NOT NULL,
    nombreplat character varying(30) NOT NULL,
    linkllamada character varying(30) NOT NULL,
    passllamada character varying(10) NOT NULL
);


ALTER TABLE public.direccioncurso OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16610)
-- Name: direccioncurso_iddir_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.direccioncurso_iddir_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.direccioncurso_iddir_seq OWNER TO postgres;

--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 208
-- Name: direccioncurso_iddir_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.direccioncurso_iddir_seq OWNED BY public.direccioncurso.iddir;


--
-- TOC entry 197 (class 1259 OID 16537)
-- Name: estudiante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estudiante (
    idestudiante integer NOT NULL,
    nombre character varying(25) NOT NULL,
    appate character varying(30) NOT NULL,
    apmate character varying(30) NOT NULL,
    telefono character varying(12) NOT NULL,
    correo character varying(30) NOT NULL,
    passestudiante character varying(18) NOT NULL,
    fechanacimiento date NOT NULL
);


ALTER TABLE public.estudiante OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16535)
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estudiante_idestudiante_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estudiante_idestudiante_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 196
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estudiante_idestudiante_seq OWNED BY public.estudiante.idestudiante;


--
-- TOC entry 207 (class 1259 OID 16594)
-- Name: horarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.horarios (
    idhorario integer NOT NULL,
    idcurso character varying(10) NOT NULL,
    idprofesor integer NOT NULL,
    hora character varying(4) NOT NULL,
    disponible boolean NOT NULL,
    nombreplataforma character varying(30) NOT NULL
);


ALTER TABLE public.horarios OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16592)
-- Name: horarios_idhorario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.horarios_idhorario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.horarios_idhorario_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 206
-- Name: horarios_idhorario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.horarios_idhorario_seq OWNED BY public.horarios.idhorario;


--
-- TOC entry 210 (class 1259 OID 16628)
-- Name: inscripcioncurso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inscripcioncurso (
    idcurso character varying(10) NOT NULL,
    idestudiante integer NOT NULL
);


ALTER TABLE public.inscripcioncurso OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16545)
-- Name: instructor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.instructor (
    idprofesor integer NOT NULL,
    "contraseña" character varying(30) NOT NULL,
    nombre character varying(30) NOT NULL,
    appat character varying(20) NOT NULL,
    apmat character varying(20) NOT NULL,
    calle character varying(30) NOT NULL,
    numext integer NOT NULL,
    codpost integer NOT NULL,
    delegacion character varying(20) NOT NULL,
    telefono character varying(12) NOT NULL
);


ALTER TABLE public.instructor OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16543)
-- Name: instructor_idprofesor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.instructor_idprofesor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instructor_idprofesor_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 198
-- Name: instructor_idprofesor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.instructor_idprofesor_seq OWNED BY public.instructor.idprofesor;


--
-- TOC entry 2729 (class 2604 OID 16566)
-- Name: calificacionesfinales idcalfinal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesfinales ALTER COLUMN idcalfinal SET DEFAULT nextval('public.calificacionesfinales_idcalfinal_seq'::regclass);


--
-- TOC entry 2730 (class 2604 OID 16584)
-- Name: calificacionesparciales llave_califi; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesparciales ALTER COLUMN llave_califi SET DEFAULT nextval('public.calificacionesparciales_llave_califi_seq'::regclass);


--
-- TOC entry 2732 (class 2604 OID 16615)
-- Name: direccioncurso iddir; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccioncurso ALTER COLUMN iddir SET DEFAULT nextval('public.direccioncurso_iddir_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 16540)
-- Name: estudiante idestudiante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudiante ALTER COLUMN idestudiante SET DEFAULT nextval('public.estudiante_idestudiante_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 16597)
-- Name: horarios idhorario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios ALTER COLUMN idhorario SET DEFAULT nextval('public.horarios_idhorario_seq'::regclass);


--
-- TOC entry 2728 (class 2604 OID 16548)
-- Name: instructor idprofesor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instructor ALTER COLUMN idprofesor SET DEFAULT nextval('public.instructor_idprofesor_seq'::regclass);


--
-- TOC entry 2888 (class 0 OID 16587)
-- Dependencies: 205
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (idadmin, passadmin) FROM stdin;
\.


--
-- TOC entry 2885 (class 0 OID 16563)
-- Dependencies: 202
-- Data for Name: calificacionesfinales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calificacionesfinales (idcalfinal, idestudiante, idcurso, calf) FROM stdin;
\.


--
-- TOC entry 2887 (class 0 OID 16581)
-- Dependencies: 204
-- Data for Name: calificacionesparciales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calificacionesparciales (llave_califi, descripcion) FROM stdin;
\.


--
-- TOC entry 2883 (class 0 OID 16551)
-- Dependencies: 200
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (idcurso, nombrecurso, descripcion, idprofesor) FROM stdin;
\.


--
-- TOC entry 2892 (class 0 OID 16612)
-- Dependencies: 209
-- Data for Name: direccioncurso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.direccioncurso (iddir, idcurso, idprofesor, nombreplat, linkllamada, passllamada) FROM stdin;
\.


--
-- TOC entry 2880 (class 0 OID 16537)
-- Dependencies: 197
-- Data for Name: estudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudiante (idestudiante, nombre, appate, apmate, telefono, correo, passestudiante, fechanacimiento) FROM stdin;
\.


--
-- TOC entry 2890 (class 0 OID 16594)
-- Dependencies: 207
-- Data for Name: horarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.horarios (idhorario, idcurso, idprofesor, hora, disponible, nombreplataforma) FROM stdin;
\.


--
-- TOC entry 2893 (class 0 OID 16628)
-- Dependencies: 210
-- Data for Name: inscripcioncurso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inscripcioncurso (idcurso, idestudiante) FROM stdin;
\.


--
-- TOC entry 2882 (class 0 OID 16545)
-- Dependencies: 199
-- Data for Name: instructor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.instructor (idprofesor, "contraseña", nombre, appat, apmat, calle, numext, codpost, delegacion, telefono) FROM stdin;
\.


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 201
-- Name: calificacionesfinales_idcalfinal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.calificacionesfinales_idcalfinal_seq', 1, false);


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 203
-- Name: calificacionesparciales_llave_califi_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.calificacionesparciales_llave_califi_seq', 1, false);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 208
-- Name: direccioncurso_iddir_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.direccioncurso_iddir_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 196
-- Name: estudiante_idestudiante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estudiante_idestudiante_seq', 1, false);


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 206
-- Name: horarios_idhorario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.horarios_idhorario_seq', 1, false);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 198
-- Name: instructor_idprofesor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.instructor_idprofesor_seq', 1, false);


--
-- TOC entry 2744 (class 2606 OID 16591)
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (idadmin);


--
-- TOC entry 2740 (class 2606 OID 16568)
-- Name: calificacionesfinales calificacionesfinales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesfinales
    ADD CONSTRAINT calificacionesfinales_pkey PRIMARY KEY (idcalfinal);


--
-- TOC entry 2742 (class 2606 OID 16586)
-- Name: calificacionesparciales calificacionesparciales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesparciales
    ADD CONSTRAINT calificacionesparciales_pkey PRIMARY KEY (llave_califi);


--
-- TOC entry 2738 (class 2606 OID 16555)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (idcurso);


--
-- TOC entry 2748 (class 2606 OID 16617)
-- Name: direccioncurso direccioncurso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccioncurso
    ADD CONSTRAINT direccioncurso_pkey PRIMARY KEY (iddir);


--
-- TOC entry 2734 (class 2606 OID 16542)
-- Name: estudiante estudiante_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (idestudiante);


--
-- TOC entry 2746 (class 2606 OID 16599)
-- Name: horarios horarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horarios_pkey PRIMARY KEY (idhorario);


--
-- TOC entry 2736 (class 2606 OID 16550)
-- Name: instructor instructor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.instructor
    ADD CONSTRAINT instructor_pkey PRIMARY KEY (idprofesor);


--
-- TOC entry 2751 (class 2606 OID 16574)
-- Name: calificacionesfinales calificacionesfinales_idcurso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesfinales
    ADD CONSTRAINT calificacionesfinales_idcurso_fkey FOREIGN KEY (idcurso) REFERENCES public.curso(idcurso) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2750 (class 2606 OID 16569)
-- Name: calificacionesfinales calificacionesfinales_idestudiante_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacionesfinales
    ADD CONSTRAINT calificacionesfinales_idestudiante_fkey FOREIGN KEY (idestudiante) REFERENCES public.estudiante(idestudiante) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2749 (class 2606 OID 16556)
-- Name: curso curso_idprofesor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_idprofesor_fkey FOREIGN KEY (idprofesor) REFERENCES public.instructor(idprofesor) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2754 (class 2606 OID 16618)
-- Name: direccioncurso direccioncurso_idcurso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccioncurso
    ADD CONSTRAINT direccioncurso_idcurso_fkey FOREIGN KEY (idcurso) REFERENCES public.curso(idcurso) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2755 (class 2606 OID 16623)
-- Name: direccioncurso direccioncurso_idprofesor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.direccioncurso
    ADD CONSTRAINT direccioncurso_idprofesor_fkey FOREIGN KEY (idprofesor) REFERENCES public.instructor(idprofesor) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2752 (class 2606 OID 16600)
-- Name: horarios horarios_idcurso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horarios_idcurso_fkey FOREIGN KEY (idcurso) REFERENCES public.curso(idcurso) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2753 (class 2606 OID 16605)
-- Name: horarios horarios_idprofesor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horarios_idprofesor_fkey FOREIGN KEY (idprofesor) REFERENCES public.instructor(idprofesor) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2756 (class 2606 OID 16631)
-- Name: inscripcioncurso inscripcioncurso_idcurso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripcioncurso
    ADD CONSTRAINT inscripcioncurso_idcurso_fkey FOREIGN KEY (idcurso) REFERENCES public.curso(idcurso) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2757 (class 2606 OID 16636)
-- Name: inscripcioncurso inscripcioncurso_idestudiante_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inscripcioncurso
    ADD CONSTRAINT inscripcioncurso_idestudiante_fkey FOREIGN KEY (idestudiante) REFERENCES public.estudiante(idestudiante) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2021-12-29 20:33:50

--
-- PostgreSQL database dump complete
--

