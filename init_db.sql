-- Schema
    -- Table: public.t_airport

    DROP TABLE IF EXISTS public.t_airport CASCADE;

    CREATE TABLE IF NOT EXISTS public.t_airport (
                                                    id bigint,
                                                    city character varying(255) COLLATE pg_catalog."default",
                                                    code character varying(255) COLLATE pg_catalog."default",
                                                    create_date_time timestamp without time zone,
                                                    update_date_time timestamp without time zone,
                                                    CONSTRAINT t_airport_pkey PRIMARY KEY (id),
                                                    CONSTRAINT t_airport_code_key UNIQUE (code)
    ) TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.t_airport OWNER TO postgres;

    -- Table: public.t_flight

    DROP TABLE IF EXISTS public.t_flight CASCADE;

    CREATE TABLE IF NOT EXISTS public.t_flight (
                                                   id bigint,
                                                   departure_airport_id bigint,
                                                   arrival_airport_id bigint,
                                                   arrival_date_time timestamp without time zone,
                                                   departure_date_time timestamp without time zone,
                                                   price character varying(255) COLLATE pg_catalog."default",
                                                   create_date_time timestamp without time zone,
                                                   update_date_time timestamp without time zone,
                                                   CONSTRAINT t_flight_pkey PRIMARY KEY (id),
                                                   CONSTRAINT fk_arrival_airport_id FOREIGN KEY (arrival_airport_id)
                                                       REFERENCES public.t_airport (id) MATCH SIMPLE
                                                       ON UPDATE NO ACTION
                                                       ON DELETE NO ACTION,
                                                   CONSTRAINT fk_departure_airport_id FOREIGN KEY (departure_airport_id)
                                                       REFERENCES public.t_airport (id) MATCH SIMPLE
                                                       ON UPDATE NO ACTION
                                                       ON DELETE NO ACTION
    ) TABLESPACE pg_default;

    ALTER TABLE IF EXISTS public.t_flight OWNER TO postgres;

    -- SEQUENCE: t_flight_id_seq

    DROP SEQUENCE IF EXISTS public.t_flight_id_seq;

    CREATE SEQUENCE IF NOT EXISTS public.t_flight_id_seq
        INCREMENT 1
        START 1
        MINVALUE 1
        MAXVALUE 9223372036854775807
        CACHE 1
        OWNED BY t_flight.id;

    ALTER SEQUENCE public.t_flight_id_seq OWNER TO postgres;

    -- SEQUENCE: public.t_airport_id_seq

    DROP SEQUENCE IF EXISTS public.t_airport_id_seq;

    CREATE SEQUENCE IF NOT EXISTS public.t_airport_id_seq
        INCREMENT 1
        START 1
        MINVALUE 1
        MAXVALUE 9223372036854775807
        CACHE 1
        OWNED BY t_airport.id;

    ALTER SEQUENCE public.t_airport_id_seq OWNER TO postgres;

    ALTER TABLE public.t_airport
        ALTER COLUMN id SET DEFAULT nextval('t_airport_id_seq'::regclass),
        ALTER COLUMN id SET NOT NULL;

    ALTER TABLE public.t_flight
        ALTER COLUMN id SET DEFAULT nextval('t_flight_id_seq'::regclass),
        ALTER COLUMN id SET NOT NULL;


-- Initial Data
    -- Airports

    INSERT INTO public.t_airport(
        create_date_time, id, update_date_time, city, code)
    VALUES
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'İstanbul', 'IST'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Ankara', 'ESB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'İzmir', 'ADB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Antalya', 'AYT'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Adana', 'ADA'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'New York', 'JFK'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Los Angeles', 'LAX'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'London', 'LHR'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Dubai', 'DXB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Hong Kong', 'HKG'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Paris', 'CDG'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Singapore', 'SIN'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Istanbul Sabiha Gökçen', 'SAW'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Ankara Esenboğa', 'ESB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'İzmir Adnan Menderes', 'ADB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Antalya Gazipaşa', 'GZP'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Bodrum Milas', 'BJV'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Dalaman', 'DLM'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Trabzon', 'TZX'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Adana Şakirpaşa', 'ADA'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'New York', 'JFK'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Los Angeles', 'LAX'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Chicago', 'ORD'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'London', 'LHR'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Tokyo', 'HND'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Paris', 'CDG'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Beijing', 'PEK'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Dubai', 'DXB'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Istanbul', 'IST'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Singapore', 'SIN'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Shanghai', 'PVG'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Hong Kong', 'HKG'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Frankfurt', 'FRA'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Amsterdam', 'AMS'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Toronto', 'YYZ'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Mumbai', 'BOM'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Sydney', 'SYD'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Seoul', 'ICN'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'San Francisco', 'SFO'),
        (CURRENT_TIMESTAMP, DEFAULT, CURRENT_TIMESTAMP, 'Mexico City', 'MEX')
    ON CONFLICT (code) DO NOTHING;