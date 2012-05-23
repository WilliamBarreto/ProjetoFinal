INSERT INTO usuario(login,senha)values('joao','12345');
INSERT INTO usuario(login,senha)values('jose','12345');
INSERT INTO usuario(login,senha)values('administrator','12345');

INSERT INTO autorizacao (papel,login)values('client','jose');
INSERT INTO autorizacao (papel,login)values('client','joao');
INSERT INTO autorizacao (papel,login)values('admin','administrator');

INSERT INTO cliente values(NULL,'JOAO','01234567890','joao@joao','QND 100 LT 01','TAGUATINGA','BRASILIA','72000000','DF','1980/04/01','joao','33334444');
INSERT INTO cliente values(NULL,'JOSE','01234567890','jose@jose','QND 100 LT 01','CEILANDIA','BRASILIA','72000000','DF','1983/04/01','jose','44443333');

INSERT INTO produto values(NULL,'ARROZ BRANCO 5KG','BRILHANTE',6.99,'CEREAIS','img01.jpg');
INSERT INTO produto values(NULL,'FEIJAO PRETO 1KG','CARIOCA',4.99,'CEREAIS','img02.jpg');
INSERT INTO produto values(NULL,'OLEO 300ML','SOYA',6.99,'CEREAIS','img03.jpg');
INSERT INTO produto values(NULL,'FARINHA 1KG','TIO JORGE',6.99,'CEREAIS','img04.jpg');

INSERT INTO venda values(NULL,'2012/05/17','1');
INSERT INTO venda values(NULL,'2012/05/17','2');

INSERT INTO venda_produto values(1,1,1,2);
INSERT INTO venda_produto values(1,1,4,2);

INSERT INTO venda_produto values(2,2,2,4);
INSERT INTO venda_produto values(2,2,3,1);

SELECT * FROM autorizacao;
SELECT * FROM usuario;
SELECT * FROM cliente;
SELECT * FROM produto;
SELECT * FROM venda;
SELECT * FROM venda_produto;

