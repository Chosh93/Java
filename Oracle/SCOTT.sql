/*
������ Ÿ��
CHAR - ���� ���� ���� ������ Ÿ��, �Էµ� ũ��� �����ϰ� ������ ���̸�ŭ�� ���� ������ Ȯ�� ��, ��������� ũ�⸦ ����ؾ� �ϸ�, ũ��� 1~2000BYTE
VARCHAR2 - ���� ���� ���� ������ Ÿ��, ���� �Էµ� �������� ũ�⸸ŭ ���� ������ ���� ��, �ִ� ũ�⸦ ����ؾ��ϰ� ũ��� 1~4000BYTE
NUMBER - ���ڸ� ��Ÿ���� ���� ������ Ÿ��(����,0,��� ����), ������ �ʿ��� �÷��� NUMBER�� ����, �������� ������ Ÿ��, �Ҽ����� �������� �ʾҴµ� �Էµǰų�, ������ �Ҽ��� �ڸ��� �̻��� �ԷµǸ� �ݿø��Ǿ� ����
` NUMBER : �ְ� 38�ڸ� ������ ���� ���� ����
` NUMBER(W) : W�ڸ������� ��ġ�� �ִ� 38�ڸ����� ����
` NUMBER(W, D) : W�� ��ü �ڸ���, D�� �Ҽ��� ���� �ڸ����� �����ϸ�, W�� �渮�� D�� ���̸� ����
DATE - ��¥�� �ð��� �����ϴ� ��¥�� ������ Ÿ��
TIMESTAMP - DATE���� Ȯ��� ���·� �и��� �������� ǥ�� ����
LONG - �������� ������ ������ Ÿ��, �ִ� ũ��� 2GB�̸�, ���̺� �Ѱ��� �÷��� ���� ����, SELECT�� ����� �����Ͱ� ���� ��ȸ
CLOB - �������� ������ ������ Ÿ��, �ִ� ũ��� 4GB�̸�, ���̺� �������� �÷��� ����, SELECT�� ����� �������� ��ġ ��ȸ
RAW, LONG RAW - �̹����� ���带 ������ �� �ִ� ������ Ÿ��, ���� �����͸� �����ϸ� 16���� ���·� ǥ��, VARCHAR2 ������ Ÿ�԰� ���������� ���� ��ȯ�� ������ �� ����
BFILE - ��뷮 ���� �����͸� ���� ���·� �����ϴ� ������ Ÿ��, �ִ� ũ��� 4GB
*/
CREATE TABLE EMP_DDL(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE,
    SAL NUMBER(7, 2),
    COMM NUMBER(7, 2),
    DEPTNO NUMBER(2)
);

SELECT * FROM EMP_DDL;

CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT;
DESC DEPT_DDL;

CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP_DDL_30;

CREATE TABLE EMPDEPT_DDL 
    AS SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE 1 != 1;

SELECT * FROM EMPDEPT_DDL;

CREATE TABLE EMP_ALTER AS SELECT *FROM EMP;
SELECT * FROM EMP_ALTER;

ALTER TABLE EMP_ALTER
    ADD HP VARCHAR(20);
SELECT * FROM EMP_ALTER;

ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL;
SELECT * FROM EMP_ALTER;

ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(2); -- ����Ұ�
ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(10);
DESC EMP_ALTER;

ALTER TABLE EMP_ALTER
DROP COLUMN TEL;
SELECT * FROM EMP_ALTER;

RENAME EMP_ALTER TO EMP_RENAME;
SELECT * FROM EMP_RENAME;

-- 1. ���� ���� ������ ������ EMP_HW���̺��� ���巯 ������.
CREATE TABLE EMP_HW(
EMPNO NUMBER(4),
ENAME VARCHAR(10),
JOB VARCHAR(9),
MGR NUMBER(4),
HIREDATE DATE,
SAL NUMBER(7, 2),
COMM NUMBER(7, 2),
DEPTNO NUMBER(2)
);
SELECT * FROM EMP_HW;

-- 2. EMP_HW ���̺� BIGO���� �߰��غ�����. BIGO���� �ڷ����� ���� ���ڿ��̰�, ���̴� 20
ALTER TABLE EMP_HW ADD BIGO VARCHAR(20);

-- 3. EMP_HW ���̺��� BIGO�� ũ�⸦ 30���� ����
ALTER TABLE EMP_HW MODIFY BIGO VARCHAR(30);

-- 4. EMP_HW ���̺��� BIGO �� �̸��� REMARK�� ����
ALTER TABLE EMP_HW RENAME COLUMN BIGO TO REMARK;

-- 5. EMP_HW ���̺� EMP ���̺��� �����͸� ��� �����غ�����, �� REMAKE���� NULL�� ����
INSERT INTO EMP_HW SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, NULL FROM EMP;

-- 6. EMP_HW ���̺� ����
DROP TABLE EMP_HW;


/* �������� : ���̺� ������ ������ �����ϴ� Ư���� ��Ģ�� �ǹ�. ���ǿ� ���� �ʴ� ������ ���� �Ұ� */
-- ���� ������� �ʴ� NOT NULL : ���� ���� �����Ϳ� �ߺ����δ� ������� NULL���� ������� ����(�ݵ�� ���� �Է� �Ǿ�� ��)

CREATE TABLE TABLE_NOTNULL(
    LOGIN_ID VARCHAR2(20) NOT NULL,
    LOGIN_PWD VARCHAR2(20) NOT NULL,
    TEL VARCHAR2(20)
);
INSERT INTO TABLE_NOTNULL(LOGIN_ID, LOGIN_PWD, TEL) VALUES('����','CHOSH', '010-4907-8820');
INSERT INTO TABLE_NOTNULL(LOGIN_ID, LOGIN_PWD, TEL) VALUES('����','BROTHER', NULL);
SELECT * FROM TABLE_NOTNULL;

/* �ߺ����� �ʴ� �� : UNIQUE */
-- ���� ������ �������� �ߺ��� ������� ����
CREATE TABLE TABLE_UNIQUE(
    LOGIN_ID VARCHAR(20) UNIQUE,
    LOGIN_PWD VARCHAR(20) NOT NULL,
    TEL VARCHAR2(20) UNIQUE
);
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES('����', 'CHOSH', '010-4907-8820');
INSERT INTO TABLE_UNIQUE(LOGIN_ID, LOGIN_PWD, TEL) VALUES(NULL, '12345', NULL);
SELECT * FROM TABLE_UNIQUE;

CREATE TABLE TABLE_PK(
    LOGIN_ID VARCHAR(20) UNIQUE,
    LOGIN_PWD VARCHAR(20) NOT NULL,
    TEL VARCHAR2(20) UNIQUE
);
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES('����', 'CHOSH', '010-4907-8820');
INSERT INTO TABLE_PK(LOGIN_ID, LOGIN_PWD, TEL) VALUES(NULL, '12345', NULL);
SELECT * FROM TABLE_PK;

CREATE TABLE DEPT_FK(
    DEPTNO NUMBER(2) CONSTRAINT DEPTFK_PEPTNO_PK PRIMARY KEY,
    DNAME VARCHAR(14),
    LOC VARCHAR(13)
);

CREATE TABLE EMP_FK(
    EMPNO NUMBER(4) CONSTRAINT EMPFK_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2) CONSTRAINT EMPFK_DEPTNO_FK REFERENCES DEPT_FK(DEPTNO)
);
INSERT INTO DEPT_FK VALUES(10, '���̺�', 'SEOUL');
INSERT INTO EMP_FK VALUES(9999, '������', '���̵�', NULL, SYSDATE, 3000, NULL, 10);
SELECT * FROM EMP_FK;

/* ������ ���¿� ������ ���ϴ� CHECK */
CREATE TABLE TABLE_CHECK(
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LOGINID_PK PRIMARY KEY,
    LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK(LENGTH(LOGIN_PWD)>3),
    TEL VARCHAR(20)
);
INSERT INTO TABLE_CHECK VALUES('����', '1234', '010-4907-8820');
SELECT * FROM TABLE_CHECK;

/* �⺻���� �����ϴ� DEFAULT */
CREATE TABLE TABLE_DEFAULT(
    LOGIN_ID VARCHAR2(20) CONSTRAINT TBCLK2_LOGINID_PK PRIMARY KEY,
    LOGIN_PWD VARCHAR2(20) DEFAULT '1234',
    TEL VARCHAR2(20)
);
INSERT INTO TABLE_DEFAULT VALUES('ASDF', NULL, 'ASDFASDFASDF');
INSERT INTO TABLE_DEFAULT (LOGIN_ID, TEL) VALUES('QWER', 'QWERQWERQWER');
SELECT * FROM TABLE_DEFAULT;

CREATE TABLE PRODUCT(
    PRODUCT_ID NUMBER CONSTRAINT PR_PRODUCT_ID_PK PRIMARY KEY,
    PRODUCT_NAME VARCHAR2(20) NOT NULL,
    REG_DATE DATE
);
INSERT INTO PRODUCT VALUES(1, 'COMPUTER', '21/01/02');
INSERT INTO PRODUCT VALUES(2, 'SAMRTPHONE', '22/02/03');
INSERT INTO PRODUCT VALUES(3, 'TELEVISION', '22/07/01');
ALTER TABLE PRODUCT ADD WEIGHT NUMBER CHECK(WEIGHT >= 0);
ALTER TABLE PRODUCT ADD PRICE NUMBER CHECK(PRICE >= 0);
SELECT * FROM PRODUCT;
--DROP TABLE PRODUCT;

CREATE TABLE CUSTOMER(
    CUSTOM_ID NUMBER CONSTRAINT CS_CUSTOM_ID_PK PRIMARY KEY,
    USER_NAME VARCHAR(12) NOT NULL,
    PHONE VARCHAR(20),
    EMAIL VARCHAR(20),
    REG_DATE DATE DEFAULT '1900/01/01'
);
ALTER TABLE CUSTOMER ADD AGE NUMBER CHECK(AGE > 0 AND AGE < 100);
ALTER TABLE CUSTOMER ADD SEX VARCHAR2(1) CHECK(SEX = 'M' OR SEX = 'F');
ALTER TABLE CUSTOMER ADD BIRTH_DATE DATE;
SELECT * FROM CUSTOMER;

/* ������ ���� */
-- ����Ŭ�� �����ͺ��̽� ���̺��� ����� ���̺�� ������ �������� ������.
-- ������ �������� �����ͺ��̽� �޸�, ����, �����, ����, ��ü �� ����Ŭ
-- �����ͺ��̽� ��� �߿��� �����Ͱ� �����Ǿ� �ִ�.
-- ������ ���� ������ �����Ϥ��ų� �����ϴ� ���� �۾��� �� �� ���� ������ ���� ������ ����
SELECT * FROM DICT;
SELECT * FROM DICTIONARY;

-- ����ڰ� ������ ��ü ������ �����Ǿ� ����
SELECT TABLE_NAME FROM USER_TABLES;

-- ALL_ ���ξ ���� ������ ������ ����Ŭ �����ͺ��̽��� ������ �ִ� ����ڰ� ������
-- ��ü �� �ٸ� ����ڰ� ������ ��ü �� ����� ����Ǿ� �ִ� ��ü ����
SELECT OWNER, TABLE_NAME
FROM ALL_TABLES;

/* �ε��� */
CREATE INDEX IDX_EMP_SAL ON EMP(SAL);
SELECT * FROM USER_IND_COLUMNS;

/* ���� ���ؽ� �����ϱ� : �ΰ� �̻��� �ķ����� �ε��� ����*�ִ� 32��) */
CREATE INDEX IDX_EMP_TUPLE ON EMP(JOB, DEPTNO);

--����ũ(UNIQUE) �ε��� ����: ����ũ �ε����� �����ϸ� �ε��������� �÷���
-- �ش� ���̺��� ������ ���̾�� �Ѵ�. ( �� �ʿ��� ��찡 �ƴϸ� ������� ���� )
CREATE UNIQUE INDEX IDX_RMP_UK ON EMP(EMPNO, MGR);
SELECT * FROM USER_IND_COLUMNS;

-- �ε��� ���� : DROP
DROP INDEX IDX_EMP_SAL;

/* VIEW : ���� ���̺��� ���� �θ���. ��� �ϳ� �̻��� ���̺��� ��ȸ�ϴ� SELECT���� ������ ��ü */
-- ��� ������ ������ �ܼ�ȭ �� �� �ֵ�.
-- ����ڿ��� �ʿ��� ������ �����ϵ��� ������ ���� �� �� �ִ�.
CREATE VIEW VW_EMP20
    AS (SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 20);

SELECT * FROM VW_EMP20;

-- �ܼ� �� �����ϱ�
-- �ܼ� ��� ���� ���̺� �ʿ��� �÷��� ���� �� �� ( GROUP BY, UNION ������� ����)
-- SELECT, INSERT, UPDATE, DELETE�� �����Ӱ� ��� ����
CREATE VIEW V_EMP
    AS(SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP);
SELECT * FROM V_EMP;

DROP VIEW V_EMP;

/* �ζ��� �並 ����� TOP-N SQL�� */
-- TOP-N������ �����ͺ��̽����� ���� ū N���� ���� �˻��ϴ� ������ �ǹ�
-- ROWNUM�� �߰��� ��ȸ�ϱ�
SELECT ROWNUM, E.*
    FROM EMP E;
    
-- �ζ��κ�(�������� �̿�)
SELECT ROWNUM, EMP.*
    FROM (SELECT * FROM EMP ORDER BY SAL DESC) EMP;

-- �ζ��κη� TOP-N �����ϱ�
SELECT ROWNUM, EMP.*
    FROM(SELECT*FROM EMP ORDER BY SAL DESC) EMP
    WHERE ROWNUM <= 3;
    
/* VIEW�� ���� DML�� ���� */
CREATE VIEW EMP_COPY_VIEW
    AS SELECT EMPNO, ENAME, DEPTNO
    FROM EMP;
SELECT * FROM EMP_COPY_VIEW;

INSERT INTO EMP_COPY_VIEW VALUES(9999,'����',30);
UPDATE EMP_COPY_VIEW
    SET DEPTNO = 20
    WHERE EMPNO = 9999;
    
    
    
