--liquibase formatted sql
--changeset neto:create-customer-table logicalFilePath:create-customer-table
CREATE TABLE customer (
  id uuid NOT NULL,
  name varchar(50) NOT NULL,
  birthdate DATE NOT NULL,
  username varchar(50) NOT NULL,
  password VARCHAR(128) NOT NULL,
  stamp_datetime timestamp with time zone NOT NULL,
  CONSTRAINT customer_pk PRIMARY KEY (id)
);
