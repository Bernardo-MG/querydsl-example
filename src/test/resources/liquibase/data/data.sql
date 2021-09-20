--
--  The MIT License (MIT)
--
--  Copyright (c) 2020 Bernardo Martínez Garrido
--  
--  Permission is hereby granted, free of charge, to any person obtaining a copy
--  of this software and associated documentation files (the 'Software'), to deal
--  in the Software without restriction, including without limitation the rights
--  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
--  copies of the Software, and to permit persons to whom the Software is
--  furnished to do so, subject to the following conditions:
--  
--  The above copyright notice and this permission notice shall be included in all
--  copies or substantial portions of the Software.
--  
--  THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
--  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
--  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
--  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
--  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
--  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
--  SOFTWARE.
--


-- ****************************************
-- This SQL script populates the initial data.
-- ****************************************

INSERT INTO SEQUENCE (seq_name, seq_count) VALUES
   ('TABLE_PER_CLASS_GENERATOR', 10),
   ('TABLE_GENERATOR', 10);

INSERT INTO simple_entities (name) VALUES
   ('entity_01'),
   ('entity_02'),
   ('entity_03'),
   ('entity_04'),
   ('entity_05'),
   ('entity_06'),
   ('entity_07'),
   ('entity_08'),
   ('entity_09'),
   ('entity_10'),
   ('entity_11'),
   ('entity_12'),
   ('entity_13'),
   ('entity_14'),
   ('entity_15'),
   ('entity_16'),
   ('entity_17'),
   ('entity_18'),
   ('entity_19'),
   ('entity_20'),
   ('entity_21'),
   ('entity_22'),
   ('entity_23'),
   ('entity_24'),
   ('entity_25'),
   ('entity_26'),
   ('entity_27'),
   ('entity_28'),
   ('entity_29'),
   ('entity_30');

INSERT INTO auto_id_entities (id, name) VALUES
   (5, 'entity_01');

INSERT INTO identity_id_entities (id, name) VALUES
   (5, 'entity_01');

INSERT INTO sequence_id_entities (id, name) VALUES
   (1, 'entity_1');

INSERT INTO table_id_entities (id, name) VALUES
   (1, 'entity_1');

INSERT INTO boolean_converter_entities (flag) VALUES
   ('T'),
   ('B'),
   ('F'),
   ('F'),
   ('T'),
   ('T'),
   ('B'),
   ('B'),
   ('B');

INSERT INTO boolean_entities (flag) VALUES
   (true),
   (false);

INSERT INTO enum_entities (enum_string, enum_ordinal) VALUES
   ('TWO', 2),
   ('THREE', 0),
   ('ONE', 1),
   ('TWO', 2);

INSERT INTO date_entities (calendar_date, java_date, sql_date) VALUES
   ('1990-02-03', '1990-02-03', '1990-02-03'),
   ('1991-05-02', '1991-05-02', '1991-05-02'),
   ('1990-02-03', '1990-02-03', '1990-02-03'),
   ('1995-01-02', '1995-01-02', '1995-01-02'),
   ('1992-01-01', '1992-01-01', '1992-01-01'),
   ('1996-12-24', '1996-12-24', '1996-12-24');

INSERT INTO time_entities (calendar_time, java_time, sql_time) VALUES
   ('11:22:33', '11:22:33', '11:22:33'),
   ('11:11:11', '11:11:11', '11:11:11'),
   ('11:22:33', '11:22:33', '11:22:33'),
   ('03:15:10', '03:15:10', '03:15:10'),
   ('12:00:00', '12:00:00', '12:00:00'),
   ('01:10:10', '01:10:10', '01:10:10');

INSERT INTO timestamp_entities (calendar_timestamp, java_timestamp, sql_timestamp) VALUES
   ('1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33'),
   ('1991-05-02 11:11:11', '1991-05-02 11:11:11', '1991-05-02 11:11:11'),
   ('1990-02-03 11:22:33', '1990-02-03 11:22:33', '1990-02-03 11:22:33'),
   ('1995-01-02 03:15:10', '1995-01-02 03:15:10', '1995-01-02 03:15:10'),
   ('1992-01-01 12:00:00', '1992-01-01 12:00:00', '1992-01-01 12:00:00'),
   ('1996-12-24 01:10:10', '1996-12-24 01:10:10', '1996-12-24 01:10:10');

INSERT INTO collection_entities (name) VALUES
   ('col_entity_1'),
   ('col_entity_2'),
   ('col_entity_3'),
   ('col_entity_4'),
   ('col_entity_5');

INSERT INTO collection_entities_values (collection_id, value_col) VALUES
   (1, 1),
   (1, 2),
   (2, 3),
   (2, 2),
   (3, 4),
   (3, 5),
   (4, 6),
   (5, 7),
   (5, 2),
   (5, 8),
   (5, 9),
   (1, 10);

INSERT INTO map_entities (name) VALUES
   ('map_entity_1'),
   ('map_entity_2'),
   ('map_entity_3'),
   ('map_entity_4'),
   ('map_entity_5');

INSERT INTO map_entities_values (map_id, name, number) VALUES
   (1, 'value_1', 1),
   (2, 'value_2', 2),
   (2, 'value_2', 3),
   (2, 'value_1', 2),
   (3, 'value_1', 4),
   (3, 'value_2', 5),
   (4, 'value_1', 6),
   (5, 'value_1', 7),
   (5, 'value_2', 2),
   (5, 'value_3', 8),
   (5, 'value_4', 9),
   (5, 'value_3', 10);

INSERT INTO embedded_entities (name, description) VALUES
   ('embedded_entity_1', 'desc_1'),
   ('embedded_entity_2', 'desc_2'),
   ('embedded_entity_3', 'desc_3'),
   ('embedded_entity_4', 'desc_4'),
   ('embedded_entity_5', 'desc_5');

INSERT INTO element_collection_entities (name) VALUES
   ('element_col_1'),
   ('element_col_2'),
   ('element_col_3'),
   ('element_col_4'),
   ('element_col_5');

INSERT INTO element_collection_entities_values (collection_id, name, description) VALUES
   (1, 'name_1', 'desc_1'),
   (1, 'name_2', 'desc_2'),
   (2, 'name_1', 'desc_1'),
   (2, 'name_2', 'desc_2'),
   (3, 'name_1', 'desc_1'),
   (3, 'name_2', 'desc_2'),
   (4, 'name_1', 'desc_1'),
   (5, 'name_1', 'desc_1'),
   (5, 'name_2', 'desc_2'),
   (5, 'name_3', 'desc_3'),
   (5, 'name_4', 'desc_4'),
   (1, 'name_3', 'desc_3');

INSERT INTO multiple_table_inherit_root_entities (name, discriminator) VALUES
   ('multi_inherit_1', 'A'),
   ('multi_inherit_2', 'B'),
   ('multi_inherit_3', 'A'),
   ('multi_inherit_4', 'B');

INSERT INTO multiple_table_inherit_value_entities (id, value) VALUES
   (1, 11),
   (3, 22);

INSERT INTO multiple_table_inherit_description_entities (id, description) VALUES
   (2, 'desc_2'),
   (4, 'desc_4');

INSERT INTO per_class_table_inherit_value_entities (name, value) VALUES
   ('per_class_inherit_1', 11),
   ('per_class_inherit_3', 22);

INSERT INTO per_class_table_inherit_description_entities (name, description) VALUES
   ('per_class_inherit_2', 'desc_2'),
   ('per_class_inherit_4', 'desc_4');

INSERT INTO single_table_inherit_entities (discriminator, name, description, value) VALUES
   ('A', 'single_inherit_1', null, 11),
   ('B', 'single_inherit_2', 'desc_2', null),
   ('A', 'single_inherit_3', null, 2),
   ('B', 'single_inherit_4', 'desc_4', null);

INSERT INTO super_class_table_inherit_value_entities (name, value) VALUES
   ('per_class_inherit_1', 11),
   ('per_class_inherit_3', 22);

INSERT INTO super_class_table_inherit_description_entities (name, description) VALUES
   ('per_class_inherit_2', 'desc_2'),
   ('per_class_inherit_4', 'desc_4');

INSERT INTO composite_key_entities (id1, id2, name) VALUES
   (1, 1, 'composite_key_1'),
   (1, 2, 'composite_key_2'),
   (2, 1, 'composite_key_3'),
   (2, 2, 'composite_key_4');

INSERT INTO composite_key_idclass_entities (id1, id2, name) VALUES
   (1, 1, 'composite_key_1'),
   (1, 2, 'composite_key_2'),
   (2, 1, 'composite_key_3'),
   (2, 2, 'composite_key_4');

INSERT INTO embedded_key_entities (id1, id2, name) VALUES
   (1, 1, 'composite_key_1'),
   (1, 2, 'composite_key_2'),
   (2, 1, 'composite_key_3'),
   (2, 2, 'composite_key_4');

INSERT INTO two_tables_entities_a (field1) VALUES
   ('value_a_1'),
   ('value_a_2'),
   ('value_a_3');

INSERT INTO two_tables_entities_b (entity_id, field2) VALUES
   (1, 'value_b_1'),
   (2, 'value_b_2'),
   (3, 'value_b_3');
