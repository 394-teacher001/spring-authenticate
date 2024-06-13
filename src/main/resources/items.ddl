DROP TABLE IF EXISTS stocks CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS category CASCADE;

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
		inport_on DATETIME NOT NULL
);


ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (code);

ALTER TABLE items ADD CONSTRAINT IDX_items_PK PRIMARY KEY (id);
ALTER TABLE items ADD CONSTRAINT IDX_items_FK FOREIGN KEY (category) REFERENCES category (code);
CREATE INDEX IDX_items_FK ON items (category);

ALTER TABLE stocks ADD CONSTRAINT IDX_stocks_PK PRIMARY KEY (id);
ALTER TABLE stocks ADD CONSTRAINT IDX_stocks_FK FOREIGN KEY (item_id) REFERENCES items (id);
CREATE INDEX IDX_stocks_FK ON stocks (item_id);

