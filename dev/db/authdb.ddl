DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS accounts;

/**********************************/
/* テーブル名: 認証 */
/**********************************/
CREATE TABLE accounts(
		id       SERIAL       NOT NULL,
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
		role        INT          NOT NULL,
		signuped_on DATE         NOT NULL DEFAULT current_date,
		canceled_on DATE                  DEFAULT null
);


ALTER TABLE accounts ADD CONSTRAINT IDX_accounts_PK PRIMARY KEY (id);
ALTER TABLE accounts ADD CONSTRAINT IDX_account_UQ UNIQUE (email, password);

ALTER TABLE role ADD CONSTRAINT IDX_role_PK PRIMARY KEY (code);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);
ALTER TABLE users ADD CONSTRAINT IDX_users_FK0 FOREIGN KEY (role) REFERENCES role (code);

