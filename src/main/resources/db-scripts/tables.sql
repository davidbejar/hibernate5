--Using docker plsql
-- Table: hibernate."PURCHASED_ITEMS"

-- DROP TABLE hibernate."PURCHASED_ITEMS";

CREATE TABLE hibernate."PURCHASED_ITEMS"
(
    "ID" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "KEY" character varying(64) COLLATE pg_catalog."default" NOT NULL,
    "DESCRIPTION" character varying(256) COLLATE pg_catalog."default" NOT NULL,
    "PRICE" numeric(30, 2) NOT NULL,
    "CURRENCY" character varying(3) COLLATE pg_catalog."default" NOT NULL,
    "PURCHASE_DATE" date NOT NULL,
    "PAYMENT_METHOD" character varying(32) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "PRIM_ID_PUR_ITMS" PRIMARY KEY ("ID")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

--Just for the sake of simplicity - not for production use
GRANT ALL ON TABLE hibernate."PURCHASED_ITEMS" TO postgres WITH GRANT OPTION;