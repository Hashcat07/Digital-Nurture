SET SERVEROUTPUT ON;

/* =========================================================
   EXERCISE 4 - SCENARIO 1
   Calculate Age Function
   Returns age in years based on DOB
   ========================================================= */
CREATE OR REPLACE FUNCTION CalculateAge(p_dob IN DATE)
RETURN NUMBER
AS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/

/* =========================================================
   EXERCISE 4 - SCENARIO 2
   Calculate Monthly Installment (EMI)
   Uses standard loan EMI formula
   ========================================================= */
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years IN NUMBER
)
RETURN NUMBER
AS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / 12 / 100;
    v_months := p_years * 12;

    IF v_monthly_rate = 0 THEN
        v_emi := p_loan_amount / v_months;
    ELSE
        v_emi := p_loan_amount * v_monthly_rate *
                 POWER(1 + v_monthly_rate, v_months) /
                 (POWER(1 + v_monthly_rate, v_months) - 1);
    END IF;

    RETURN ROUND(v_emi, 2);
END;
/

/* =========================================================
   EXERCISE 4 - SCENARIO 3
   Check Sufficient Balance Function
   Returns TRUE/FALSE based on account balance
   ========================================================= */
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
)
RETURN BOOLEAN
AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

/* =========================================================
   TEST BLOCK (BOOLEAN FUNCTION)
   ========================================================= */
BEGIN
    IF HasSufficientBalance(1, 500) THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance');
    END IF;
END;
/