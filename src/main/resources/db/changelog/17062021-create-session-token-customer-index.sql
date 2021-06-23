--liquibase formatted sql
--changeset neto:create-session-token-customer-index logicalFilePath:create-session-token-customer-index
CREATE INDEX idx_session_token_customer ON session_token (customer_id);

