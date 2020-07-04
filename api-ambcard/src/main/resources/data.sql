DROP TABLE IF EXISTS WALLET;
 
CREATE TABLE WALLET (
  id VARCHAR(250) NOT NULL,
  CUSTOMER_ID VARCHAR(250)  NULL,
  cpf VARCHAR(250) NOT NULL
);


INSERT INTO WALLET (id,customer_id, cpf) VALUES
  ('918cf58a-4448-431c-9052-1b5995558c2f','0635c81f-3e75-4e0f-a248-a919e9f0dde0','03118554000186'),
  ('4374a8f7-e1b3-48a6-a05c-1bafb5b29101','b557c6c8-8556-4be1-a386-de64d313cf60','02584712000120'),
  ('8a67e787-3266-479c-9fbf-bc40d4320e37','5e9a2dd7-94b3-4565-9a56-b626415ad003','36439795000186'),
  ('1fec4b5e-0a5b-42f7-a9e2-0fbd55f0fddd','d1dc9997-1aec-4e7e-ad06-18d8d41d727a','33210784000131');

INSERT INTO WALLET (id, cpf) VALUES
('c837f9aa-d0f2-4adc-8099-8be63a99c6f3','22561547000107'),
('6b403785-1ae4-4d30-bd12-8b6a83f2d487','11971414000184'),
('1237ccf4-9dd9-4fe0-9f56-55a6f8a3015e','54228161000166'),
('22188d55-7546-43ce-9a13-e16efae9e193','40504037000171');