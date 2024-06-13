DROP TABLE IF EXISTS stocks CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS category CASCADE;

DROP VIEW  IF EXISTS vaccounts CASCADE;
DROP TABLE IF EXISTS users     CASCADE;
DROP TABLE IF EXISTS role      CASCADE;
DROP TABLE IF EXISTS accounts  CASCADE;

/**********************************/
/* テーブル名: カテゴリマスタ */
/**********************************/
CREATE TABLE category(
		code SERIAL       NOT NULL,
		name VARCHAR(255) NOT NULL
);

/**********************************/
/* テーブル名: 商品 */
/**********************************/
CREATE TABLE items(
		id       SERIAL       NOT NULL,
		category INT,
		name     VARCHAR(255) NOT NULL,
		price    INT          NOT NULL
);

/**********************************/
/* テーブル名: 在庫 */
/**********************************/
CREATE TABLE stocks(
		id      SERIAL     NOT NULL,
		item_id INT        NOT NULL,
		stock   INT        NOT NULL,
		inport_on TIMESTAMP NOT NULL
);

ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (code);

ALTER TABLE items ADD CONSTRAINT IDX_items_PK PRIMARY KEY (id);
ALTER TABLE items ADD CONSTRAINT IDX_items_FK FOREIGN KEY (category) REFERENCES category (code);
CREATE INDEX IDX_items_FK ON items (category);

ALTER TABLE stocks ADD CONSTRAINT IDX_stocks_PK PRIMARY KEY (id);
ALTER TABLE stocks ADD CONSTRAINT IDX_stocks_FK FOREIGN KEY (item_id) REFERENCES items (id);
CREATE INDEX IDX_stocks_FK ON stocks (item_id);

/**********************************/
/* テーブル名: 認証 */
/**********************************/
CREATE TABLE accounts(
		id       SERIAL       NOT NULL,
		role     INTEGER      NOT NULL,
		name     VARCHAR(255) NOT NULL,
		email    VARCHAR(255) NOT NULL,
		password VARCHAR(255) NOT NULL
);

/**********************************/
/* テーブル名: 権限 */
/**********************************/
CREATE TABLE role(
		code SERIAL      NOT NULL,
		name VARCHAR(10) NOT NULL
);

/**********************************/
/* テーブル名: 利用者 */
/**********************************/
CREATE TABLE users(
		id          SERIAL       NOT NULL,
		name        VARCHAR(255) NOT NULL,
		address     VARCHAR,
		zipcode     CHAR(8),
		phone       CHAR(14)     NOT NULL,
		email       VARCHAR(255) NOT NULL,
		birthday    DATE,
		role        INTEGER      NOT NULL,
		signuped_on DATE         NOT NULL DEFAULT current_date,
		canceled_on DATE                  DEFAULT null
);

/**********************************/
/* view名: アカウントビュウ */
/**********************************/
CREATE VIEW vaccounts AS
SELECT
	accounts.id       AS id,
    users.role        AS role,
    accounts.name     AS name, 
    accounts.email    AS email,
	accounts.password AS password
FROM accounts
JOIN users ON users.email = accounts.email;

ALTER TABLE accounts ADD CONSTRAINT IDX_accounts_PK PRIMARY KEY (id);
ALTER TABLE accounts ADD CONSTRAINT IDX_accounts_UQ UNIQUE (email, password);

ALTER TABLE role ADD CONSTRAINT IDX_role_PK PRIMARY KEY (code);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);
ALTER TABLE users ADD CONSTRAINT IDX_users_FK FOREIGN KEY (role) REFERENCES role (code);

