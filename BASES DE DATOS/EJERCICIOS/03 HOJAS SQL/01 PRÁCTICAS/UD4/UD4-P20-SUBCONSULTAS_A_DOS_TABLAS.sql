SELECT * FROM EMPLE
WHERE DEPT_NO IN(SELECT DEPT_NO FROM DEPART
                 WHERE LOC IN('MADRID','BARCELONA'));

SELECT * FROM EMPLE
WHERE DEPT_NO IN(SELECT DEPT_NO FROM DEPART
                 WHERE LOC IN('MADRID','BARCELONA'))
    AND SALARIO > 2000;