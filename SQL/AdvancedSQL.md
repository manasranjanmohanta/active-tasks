1. #### Subqueries in SQL
	- A subquery is a query which is written inside an another query.
	- Example: 
	```sql
		SELECT EMPID, NAME, DEPT, SALARY 
		FROM EMPLOYEE WHERE SALARY > 
			(SELECT AVG(SALARY) FROM EMPLOYEE);
			
		SELECT EMPID, NAME, GENDER, DEPT, SALARY 
		FROM EMPLOYEE WHERE SALARY > 
			(SELECT SALARY FROM EMPLOYEE WHERE NAME = 'John');
	```

1. #### Stored Procedures in SQL
	- A Stored procedures is a SQL code that can be stored/saved and re-used over and over again.
	- Example:
	```sql
		-- CREATE A PROCEDURE
		DELIMITER &&
		CREATE PROCEDURE procedure_name()
		BEGIN
			select name, country, goals
			from players where goals > 6;
		END &&
		DELIMITER ;
		
		-- CALL A PROCEDURE
		CALL procedure_name();
		
		
		---------------------------------------------------------------------
		
		
		-- IN
		DELIMITER //
		CREATE PROCEDURE sp_sortBySalary(
			IN var int
		)
		BEGIN
			select name, age, salary from emp_details
			order by salary desc limit var;
		END //
		DELIMITER ;
		
		-- CALL A PROCEDURE
		CALL sp_sortBySalary(3); -- display only the top 3 employee
		
		
		--------------------------------------------------------------------
		
		
		-- OUT
		DELIMITER //
		CREATE PROCEDURE sp_CountEmployees(
			OUT Total_Emps int
		)
		BEGIN
			select count(name) into Total_Emps from emp_details
			where sex = 'F';
		END //
		DELIMITER ;
		
		-- CALL PROCEDURE
		CALL sp_CountEmployees(@F_emp);
		SELECT @F_emp AS female_emp;
		
		
		--------------------------------------------------------------------
		
		
		-- INOUT
		DELIMITER //
		CREATE PROCEDURE ApplyTax(INOUT price DECIMAL(10,2))
		BEGIN
		    -- Takes the incoming price, adds 10% tax, 
		    -- and overwrites the same variable
		    SET price = price * 1.10;
		END //
		DELIMITER ;
		
		SET @item_price = 100.00;
		CALL  ApplyTax(@item_price);
		SELECT @item_price AS FinalPrice;
	```

1.  #### Triggers in SQL
	- A Trigger is a special type of Stored Procedure which runs automatically when a specific event occurs in database.
	- There are 3 different type of triggers in SQL.
		1. **Data Manipulation Trigger**
			- These fire when data in a table or view changes through `INSERT`, `UPDATE`, or `DELETE` statements.
		2. **Data Definition Trigger**
			- These fire in response to schema changes such as `CREATE`, `ALTER`, or `DROP` statements.
		3. **Logon / System Trigger**
			- These fire when a user establishes a database session (`LOGON`) or during system events like database startup and shutdown.
	- Example:
	```sql
		create trigger [trigger_name]   
		[before | after]    
		{insert | update | delete}    
		on [table_name]    
		FOR EACH ROW  
		BEGIN  
		END;
		
		-- Step 1: Create Main Table
		CREATE TABLE users (  
		    id INT PRIMARY KEY,  
		    name VARCHAR(50),  
		    email VARCHAR(100),  
		    updated_at TIMESTAMP  
		);
		-- Step 2: Create Trigger
		-- This trigger automatically updates the `updated_at` field whenever the user record is modified.
		CREATE TRIGGER update_timestamp  
		BEFORE UPDATE ON users  
		FOR EACH ROW  
		BEGIN  
		    SET NEW.updated_at = CURRENT_TIMESTAMP;  
		END;
		
		-- Step 3: Insert Sample Data
		INSERT INTO users (id, name, email) VALUES (1, 'Amit', 'amit@example.com');
		
		-- Step 4: Update a Record
		UPDATE users SET email = 'amit_new@example.com' WHERE id = 1;
		
		
		---------------------------------------------------------------------
		
		
		  DELIMITER //
		  CREATE TRIGGER marks_verify_st
		  BEFORE INSERT ON student
		  FOR EACH ROW
		  BEGIN
		  IF NEW.marks < 0 THEN SET NEW.marks = 50;
		  END IF;
		  END //
		  
		  -- DROP TRIGGER
		  DROP TRIGGER_NAME;
	```

3. #### Views in SQL
	- A SQL View is a virtual table created from the result of a SELECT query.
	-  It does not store data physically but displays data stored in underlying tables.
	```sql
		  CREATE VIEW view_name
		  AS
		  SELECT * FROM table_name;
		  
		  -- EXAMPLE
		  CREATE VIEW vw_student
		  AS
		  SELECT * FROM student
		  WHERE age > 18;
		  
		  -- RENAME VIEW
		  RENAME TABLE view_name
		  TO new_view_name;
		  
		  -- SHOW ALL VIEWS
		  SHOW FULL TABLES 
		  WHERE TABLE_TYPE = 'VIEW';
		  
		  -- DELETE VIEW
		  DROP VIEW view_name;
	```
  
3. #### Window Function in SQL
	- SQL window functions allow performing calculations across a set of rows that are related to the current row, without collapsing the result into a single value. 
	- They are commonly used for tasks like aggregates, rankings and running totals. The OVER clause defines the “window” of rows for the calculation. 
	- It can:
		- *** PARTITION BY:*** It divides the data into groups using [PARTITION BY].
		- *** ORDER BY: *** It specifies the order of rows within each group using [ORDER BY].
		
	- 1. **Ranking Functions** : Ranking functions assign a number to each row within a partition based on a specific order.
			- `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()` 
			-  **Question:** How do employees rank by salary within their respective departments? *
			-  **Query:**
			```sql 
				SELECT 
					employee_name, 
					department, 
					salary, 
					 ROW_NUMBER() OVER(
						 PARTITION BY department 
						 ORDER BY salary DESC
					) AS row_num,
					 RANK() OVER(
						 PARTITION BY department 
						 ORDER BY salary DESC
					) AS rank_num,
					 DENSE_RANK() OVER(
						 PARTITION BY department 
						 ORDER BY salary DESC
					) AS dense_rank_num 
				FROM employees;
			```
			- **Difference:** If two people tie for 1st place, `ROW_NUMBER` assigns `1` and `2`, `RANK` assigns `1`, `1`, and skips to `3`, while `DENSE_RANK` assigns `1`, `1`, and continues with `2`.
			
	- 2.  **Value/Navigation Functions** : Value functions retrieve data from other rows relative to the current row without needing a self-join.
			- > **`LAG()` and `LEAD()`**
			- **Question:** Within each department, how does an employee's salary compare to the person earning just above (`LAG`) and just below (`LEAD`) them?
			- **Query:**
			```sql 
				SELECT 
				    employee_name,
				    department,
				    salary,
				    LAG(salary, 1) OVER(
					    PARTITION BY department 
					    ORDER BY salary DESC
					) AS next_higher_salary,
				    LEAD(salary, 1) OVER(
					    PARTITION BY department 
					    ORDER BY salary DESC
					) AS next_lower_salary
				FROM employees;
			```
			- **Explanation:** `LAG` looks backward to the previous row in the partition, while `LEAD` looks forward to the next row.
			- >  **`FIRST_VALUE()` and `LAST_VALUE()`**
			- **Question:** Who is the highest-paid and lowest-paid employee in each department?
		    - **Query:**
			```sql 
				SELECT 
				    employee_name,
				    department,
				    salary,
				    FIRST_VALUE(employee_name) OVER(
				        PARTITION BY department 
				        ORDER BY salary DESC
				    ) AS highest_paid_emp,
				    LAST_VALUE(employee_name) OVER(
				        PARTITION BY department 
				        ORDER BY salary DESC 
				        ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
				    ) AS lowest_paid_emp
				FROM employees;
			```
			- **Explanation:** `LAST_VALUE` requires `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING` so the database looks at the entire partition rather than stopping at the current row.
			- > **`NTH_VALUE()`
			- **Question:** Who has the 2nd highest salary in each department?
		    - **Query:**
		    ```sql 
				SELECT 
				    employee_name,
				    department,
				    salary,
				    NTH_VALUE(employee_name, 2) OVER(
				        PARTITION BY department 
				        ORDER BY salary DESC 
				        ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
				    ) AS second_highest_emp
				FROM employees;
			```
			- **Explanation:** Returns the value from the Nth row (here, the 2nd row) of the window frame, or `NULL` if the department only has one employee.
	- 3. **Aggregate Window Functions** : Standard aggregate functions become window functions when paired with an `OVER()` clause, keeping individual rows intact while showing group totals.
			- > **`SUM()`, `AVG()`, `COUNT()`, `MIN()`, and `MAX()`
			- **Question:** For each employee, what is their department's total payroll, average salary, headcount, and how much do they differ from the department average?
			- **Query:**
			```sql 
				SELECT 
					employee_name,
					department,
					salary,
					SUM(salary) OVER(PARTITION BY department) AS dept_total_salary,
					ROUND(AVG(salary) OVER(PARTITION BY department), 2) AS dept_avg_salary,
					COUNT(*) OVER(PARTITION BY department) AS dept_headcount,
					salary - ROUND(AVG(salary) OVER(PARTITION BY department), 2) AS diff_from_avg
				FROM employees;
			```
			- **Explanation:** Calculates department-level metrics alongside every individual employee row without collapsing the rows like a `GROUP BY` would.
