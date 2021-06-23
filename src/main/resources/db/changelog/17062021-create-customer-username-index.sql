--liquibase formatted sql
--changeset neto:customer-username-index logicalFilePath:customer-username-index
CREATE INDEX customer_username ON customer (username);