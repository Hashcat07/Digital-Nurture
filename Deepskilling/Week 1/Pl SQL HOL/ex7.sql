SET SERVEROUTPUT ON;

/* =========================================================
   EXERCISE 7.1 - PACKAGE: CustomerManagement
   ========================================================= */

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    ) AS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
        VALUES(p_id, p_name, p_dob, p_balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
        COMMIT;
    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    ) AS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_id;

        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_id);
        COMMIT;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    ) RETURN NUMBER AS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/

/* =========================================================
   EXERCISE 7.2 - PACKAGE: EmployeeManagement
   ========================================================= */

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2,
        p_hiredate DATE
    );

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2,
        p_hiredate DATE
    ) AS
    BEGIN
        INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES(p_id, p_name, p_position, p_salary, p_dept, p_hiredate);

        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2
    ) AS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary,
            Department = p_dept
        WHERE EmployeeID = p_id;

        DBMS_OUTPUT.PUT_LINE('Employee updated: ' || p_id);
        COMMIT;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER AS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_id;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

/* =========================================================
   EXERCISE 7.3 - PACKAGE: AccountOperations
   ========================================================= */

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    ) AS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES(p_account_id, p_customer_id, p_type, p_balance, SYSDATE);

        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_account_id);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    ) AS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;

        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_account_id);
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER AS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total;
    END GetTotalBalance;

END AccountOperations;
/