INSERT INTO parties(id, letter, name, slogan, total_number_of_votes)
VALUES
(1, 'SF', 'Socialistisk Folkeparti', 'SF – et moderne grønt venstrefløjsparti baseret på lighed og frihed.', 0),
(2, 'DF', 'Dansk Folkeparti', 'Mindre EU mere danmark', 0),
(3, 'A', 'Socialdemokratiet', 'Den bedste opfindelse er danmark', 0);


INSERT INTO candidates(id, name, political_view, parti_id, personal_votes)
VALUES
(1, 'Simon Paulsen', 'Jeg går ind for mennesker', 1, 3),
(2, 'Jasmin Luppes', 'Et bedre Hvidovre', 3, 4),
(3, 'Ander Toft', 'Alt det gode', 3, 4),
(4, 'Camilla Simonsen', 'En fortjent alderdom', 2, 6);