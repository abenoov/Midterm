PGDMP         9                x            electricity    12.1    12.0     N           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            O           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            P           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Q           1262    17602    electricity    DATABASE     i   CREATE DATABASE electricity WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';
    DROP DATABASE electricity;
                postgres    false            �            1259    17619    bills    TABLE        CREATE TABLE public.bills (
    id integer NOT NULL,
    name text,
    kwh integer,
    price integer,
    user_id integer
);
    DROP TABLE public.bills;
       public         heap    postgres    false            �            1259    17617    bills_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bills_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.bills_id_seq;
       public          postgres    false    205            R           0    0    bills_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.bills_id_seq OWNED BY public.bills.id;
          public          postgres    false    204            �            1259    17603    users    TABLE     Y   CREATE TABLE public.users (
    id integer NOT NULL,
    name text,
    money integer
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    17606    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    202            S           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    203            �           2604    17622    bills id    DEFAULT     d   ALTER TABLE ONLY public.bills ALTER COLUMN id SET DEFAULT nextval('public.bills_id_seq'::regclass);
 7   ALTER TABLE public.bills ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �           2604    17608    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202            K          0    17619    bills 
   TABLE DATA           >   COPY public.bills (id, name, kwh, price, user_id) FROM stdin;
    public          postgres    false    205          H          0    17603    users 
   TABLE DATA           0   COPY public.users (id, name, money) FROM stdin;
    public          postgres    false    202   O       T           0    0    bills_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.bills_id_seq', 7, true);
          public          postgres    false    204            U           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 1, false);
          public          postgres    false    203            �           2606    17627    bills bills_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.bills DROP CONSTRAINT bills_pkey;
       public            postgres    false    205            �           2606    17616    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    202            K   4   x�3����,�L��42615�4�2L��8�2�3J8��L�9-��1z\\\ <!
�      H   "   x�32605��-��(I,�46153������� W��     