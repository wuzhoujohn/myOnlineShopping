CREATE TABLE category(
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(20),
	is_active BOOLEAN,
	
	CONSTRAINT pk_catergory_id PRIMARY KEY(id)
);