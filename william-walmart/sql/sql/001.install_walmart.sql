DROP TABLE TB_MALHA CASCADE CONSTRAINTS
DROP TABLE TB_MALHA_TB_PONTO CASCADE CONSTRAINTS
DROP TABLE TB_PONTO CASCADE CONSTRAINTS
DROP TABLE TB_PONTO_TB_TRECHO CASCADE CONSTRAINTS
DROP TABLE TB_TRECHO CASCADE CONSTRAINTS
DROP SEQUENCE HIBERNATE_SEQUENCE

CREATE TABLE TB_MALHA (
  ID_MALHA NUMBER(19,0) NOT NULL, 
  DATETIME_ULTIMA_INCLUSAO TIMESTAMP, 
  DATETIME_INCLUSAO TIMESTAMP, 
  NOME VARCHAR2(255 CHAR), 
  PRIMARY KEY (ID_MALHA)
)

CREATE TABLE TB_MALHA_TB_PONTO (
  TB_MALHA_ID_MALHA NUMBER(19,0) NOT NULL, 
  PONTOS_ID_PONTO NUMBER(19,0) NOT NULL, 
  UNIQUE (PONTOS_ID_PONTO)
)

CREATE TABLE TB_PONTO (
  ID_PONTO NUMBER(19,0) NOT NULL, 
  NOME VARCHAR2(255 CHAR), 
  ID_MALHA NUMBER(19,0), 
  PRIMARY KEY (ID_PONTO)
)

CREATE TABLE TB_PONTO_TB_TRECHO (
  TB_PONTO_ID_PONTO NUMBER(19,0) NOT NULL, 
  TRECHOS_ID_TRECHO NUMBER(19,0) NOT NULL, 
  UNIQUE (TRECHOS_ID_TRECHO)
)

CREATE TABLE TB_TRECHO (
  ID_TRECHO NUMBER(19,0) NOT NULL, 
  DISTANCIA DOUBLE PRECISION, 
  ID_PONTO_DESTINO NUMBER(19,0), 
  ID_PONTO_ORIGEM NUMBER(19,0), 
  PRIMARY KEY (ID_TRECHO)
)

ALTER TABLE TB_MALHA_TB_PONTO ADD CONSTRAINT FKBBFE218A0A2227C FOREIGN KEY (PONTOS_ID_PONTO) REFERENCES TB_PONTO
ALTER TABLE TB_MALHA_TB_PONTO ADD CONSTRAINT FKBBFE21832235853 FOREIGN KEY (TB_MALHA_ID_MALHA) REFERENCES TB_MALHA
ALTER TABLE TB_PONTO ADD CONSTRAINT FK5FE6D3D916BFA234 FOREIGN KEY (ID_MALHA) REFERENCES TB_MALHA
ALTER TABLE TB_PONTO_TB_TRECHO ADD CONSTRAINT FK38C48BAE6C7305A5 FOREIGN KEY (TRECHOS_ID_TRECHO) REFERENCES TB_TRECHO
ALTER TABLE TB_PONTO_TB_TRECHO ADD CONSTRAINT FK38C48BAE4968452C FOREIGN KEY (TB_PONTO_ID_PONTO) REFERENCES TB_PONTO
ALTER TABLE TB_TRECHO ADD CONSTRAINT FKA3ECF8942727DA6F FOREIGN KEY (ID_PONTO_DESTINO) REFERENCES TB_PONTO
ALTER TABLE TB_TRECHO ADD CONSTRAINT FKA3ECF894450346E2 FOREIGN KEY (ID_PONTO_ORIGEM) REFERENCES TB_PONTO

CREATE SEQUENCE HIBERNATE_SEQUENCE