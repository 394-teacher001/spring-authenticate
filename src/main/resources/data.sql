-- 権限テーブルへの登録
INSERT INTO role (code, name) VALUES (0, 'システム管理者');
INSERT INTO role (code, name) VALUES (1, '一般利用者');

INSERT INTO users (name, zipcode, address, phone, email, birthday, role) 
VALUES ('ほげほげ夫', '111-1111', '日出ずる処', '03-3000-0000', 'hoge@aaa.com', '2000-01-01', 0);

-- accountsテーブルへの登録
INSERT INTO accounts (role, name, email, password) VALUES (0, 'ほげほげ夫', 'hoge@aaa.com', 'himitu');