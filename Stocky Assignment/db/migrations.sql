CREATE DATABASE assignment;

-- USERS
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       created_at TIMESTAMP DEFAULT now()
);

-- REWARD EVENTS
CREATE TABLE rewards (
                         id UUID PRIMARY KEY,
                         user_id UUID NOT NULL,
                         stock_symbol VARCHAR(20) NOT NULL,
                         quantity NUMERIC(18,6) NOT NULL,
                         rewarded_at TIMESTAMP NOT NULL,
                         event_id VARCHAR(100) UNIQUE,
                         created_at TIMESTAMP DEFAULT now()
);

-- DOUBLE ENTRY LEDGER
CREATE TABLE ledger_entries (
                                id UUID PRIMARY KEY,
                                reference_id UUID,
                                entry_type VARCHAR(30), -- STOCK, CASH, FEES
                                stock_symbol VARCHAR(20),
                                debit NUMERIC(18,4),
                                credit NUMERIC(18,4),
                                created_at TIMESTAMP DEFAULT now()
);

-- STOCK PRICES
CREATE TABLE stock_prices (
                              stock_symbol VARCHAR(20) PRIMARY KEY,
                              price_inr NUMERIC(18,4),
                              updated_at TIMESTAMP
);
