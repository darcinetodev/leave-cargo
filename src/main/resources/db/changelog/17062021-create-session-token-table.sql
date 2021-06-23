--liquibase formatted sql
--changeset neto:create-session-token-table logicalFilePath:create-session-token-table
CREATE TABLE session_token (
  token uuid NOT NULL,
  customer_id uuid NOT NULL,
  stamp_datetime timestamp with time zone NOT NULL,
  CONSTRAINT session_token_pk PRIMARY KEY (token)
);

ALTER TABLE session_token
    ADD CONSTRAINT customer_fk
    FOREIGN KEY (customer_id)
    REFERENCES customer(id);