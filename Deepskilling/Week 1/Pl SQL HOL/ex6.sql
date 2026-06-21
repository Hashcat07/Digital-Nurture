SET SERVEROUTPUT ON;

/* =========================================================
   EXERCISE 6 - SCENARIO 1
   Generate Monthly Statements using explicit cursor
   ========================================================= */
DECLARE
    CURSOR stmt_cursor IS
        SELECT c.Name,
               t.TransactionID,
               t.Amount,
               t.TransactionType,
               t.TransactionDate
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.Name;

    v_row stmt_cursor%ROWTYPE;
BEGIN
    OPEN stmt_cursor;

    LOOP
        FETCH stmt_cursor INTO v_row;
        EXIT WHEN stmt_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_row.Name ||
            ' | TxnID: ' || v_row.TransactionID ||
            ' | Type: ' || v_row.TransactionType ||
            ' | Amount: ' || v_row.Amount ||
            ' | Date: ' || TO_CHAR(v_row.TransactionDate, 'DD-MON-YYYY')
        );
    END LOOP;

    CLOSE stmt_cursor;
END;
/

/* =========================================================
   EXERCISE 6 - SCENARIO 2
   Apply Annual Fee using cursor FOR UPDATE
   ========================================================= */
DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    v_fee NUMBER := 100;
BEGIN
    FOR acc IN acc_cursor LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF acc_cursor;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' deducted from all accounts.');
END;
/

/* =========================================================
   EXERCISE 6 - SCENARIO 3
   Update Loan Interest Rates using cursor
   ========================================================= */
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;

    v_loan_id NUMBER;
    v_rate NUMBER;
    v_new_rate NUMBER;
BEGIN
    OPEN loan_cursor;

    LOOP
        FETCH loan_cursor INTO v_loan_id, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        IF v_rate < 5 THEN
            v_new_rate := v_rate + 0.5;
        ELSE
            v_new_rate := v_rate + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF loan_cursor;
    END LOOP;

    CLOSE loan_cursor;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');
END;
/