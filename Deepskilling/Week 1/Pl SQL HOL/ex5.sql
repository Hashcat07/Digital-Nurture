SET SERVEROUTPUT ON;

/* =========================================================
   EXERCISE 5 - SCENARIO 1
   Automatically update LastModified in Customers
   whenever a customer row is updated
   ========================================================= */
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

/* =========================================================
   EXERCISE 5 - SCENARIO 2
   Log every transaction into AuditLog table
   (works because AuditLog is now created)
   ========================================================= */
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog(TransactionID, AccountID, Amount, TransactionType, LogDate)
    VALUES(
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );
END;
/

/* =========================================================
   EXERCISE 5 - SCENARIO 3
   Validate transaction rules before inserting into Transactions
   Rules:
   1. Amount must be > 0
   2. Withdrawal must not exceed account balance
   ========================================================= */
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Amount must be greater than zero');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance for withdrawal');
        END IF;
    END IF;
END;
/