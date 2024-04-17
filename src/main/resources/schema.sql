-- JoinColumn
CREATE TABLE child (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY,
  PRIMARY KEY (id)
);
CREATE TABLE mother (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY,
  child_id INTEGER,
  PRIMARY KEY (id)
);

-- mother has foreign key
ALTER TABLE IF EXISTS mother DROP CONSTRAINT IF EXISTS child_id_fk;
ALTER TABLE IF EXISTS mother ADD CONSTRAINT child_id_uq UNIQUE (child_id);
ALTER TABLE IF EXISTS mother ADD CONSTRAINT child_id_fk FOREIGN KEY (child_id) REFERENCES child;
