CREATE TABLE pet_types (
  id SERIAL PRIMARY KEY,
  type VARCHAR(30) NOT NULL,
  description VARCHAR(255),
  img_url VARCHAR(255) NOT NULL
);

CREATE TABLE adoptable_pets(
  id SERIAL PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  img_url VARCHAR(255) NOT NULL,
  age INTEGER,
  vaccination_status BOOLEAN,
  adoption_story VARCHAR(255) NOT NULL,
  adoption_status VARCHAR(10) NOT NULL,
  type_id INTEGER REFERENCES pet_types(id) NOT NULL
);

CREATE TABLE pet_surrender_applications(
  id SERIAL PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  phone_number VARCHAR(10) NOT NULL,
  email VARCHAR(30) NOT NULL,
  pet_name VARCHAR(30) NOT NULL,
  pet_age INTEGER,
  pet_type_id INTEGER REFERENCES pet_types(id) NOT NULL,
  pet_image_url VARCHAR(255) NOT NULL,
  vaccination_status BOOLEAN,
  application_status VARCHAR(10) NOT NULL
 );


CREATE TABLE adoption_applications(
  id SERIAL PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  phone_number VARCHAR(10) NOT NULL,
  email VARCHAR(30) NOT NULL,
  home_status VARCHAR(10) NOT NULL,
  application_status VARCHAR(10) NOT NULL,
  pet_id INTEGER REFERENCES adoptable_pets(id) NOT NULL
);
