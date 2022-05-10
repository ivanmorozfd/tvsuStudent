INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(1, 'student', '$2a$10$9AODhyVLlLWnIgMRVmWL9e5ypLqOVcEiN8U0TyDHenxfDVGEzQRLS', 'STUDENT', true, 'Иванов Иван Иванович'); /* # password: student */
INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(2, 'teacher', '$2a$10$b/nfiCIk3Kha0ag8Yzt1tudYhZfS3WbFaYBfclDbPVHvNr2UfXkIG', 'TEACHER', true, 'Семыкина Наталья Александровна'); /* # password: teacher */
INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(3, 'tishina', '$2a$10$DD.hojyxYnyE4eZqOlZZSeVN/AtjLnSXcPOsbLhgiDN9EPI8DWggq', 'TEACHER', true, 'Тишина Елена Валерьвна');
INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(4, 'shapovalova', '$2a$10$qs/1HPmCxUmKRCz7Pw.0sewYMFedZ7sPVYRQEXAA6zQIoBG335cDG', 'TEACHER', true, 'Шаповалова Инна Анатольевна');
INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(5, 'nekrasov', '$2a$10$zngLgQZiYcrVIv8v3ZIKDOetp9kf51AjK7d6u2FvfPpAVVrtcZEZK', 'TEACHER', true, 'Некрасов Константин Генадьевич');
INSERT INTO user (id, username, password, role, enabled, full_name) VALUES(6, 'ciruleva', '$2a$10$qGYpavjT9mct/ssgu.iVz.4xS7RZt/qMpckb.o57HnOKGHT7a.JrO', 'TEACHER', true, 'Цирулева Валентина Михайловна');

INSERT INTO study_group(id, name) VALUE (1, 'M-55');

INSERT INTO student (id, study_group_id) VALUES(1, 1);

INSERT INTO educator_title(id, name) VALUES (1, 'Старший научный руководитель');
INSERT INTO educator_title(id, name) VALUES (2, 'Младший научный руководитель');
INSERT INTO educator_title(id, name) VALUES (3,  'Старший специалист');

INSERT INTO teacher(id, title_id) VALUES (2, 1);
INSERT INTO teacher(id, title_id) VALUES (3, 3);
INSERT INTO teacher(id, title_id) VALUES (4, 2);
INSERT INTO teacher(id, title_id) VALUES (5, 3);
INSERT INTO teacher(id, title_id) VALUES (6, 1);
INSERT INTO teacher(id, title_id) VALUES (7, 2);

INSERT INTO room VALUES (97,'224 Кабинет истории');
INSERT INTO room VALUES (98,'314 Кабинет математики');
INSERT INTO room VALUES (99,'203 Кабинет для занятий');
INSERT INTO room VALUES (100,'207 Кабинет математики');
INSERT INTO room VALUES (101,'Teams');
INSERT INTO room VALUES (102,'LMS');
INSERT INTO room VALUES (103,'215 Кабинет алгебры');

INSERT INTO lesson(id, name) VALUES (103,'Web-programming');
INSERT INTO lesson(id, name) VALUES (104,'AI system analysis');
INSERT INTO lesson(id, name) VALUES (105,'Computational Complexety Theory');
INSERT INTO lesson(id, name) VALUES (106,'Digital Systems Software');
INSERT INTO lesson(id, name) VALUES (107,'Mass Service Theory');
INSERT INTO lesson(id, name) VALUES (108,'Non-linear systems management');
INSERT INTO lesson(id, name) VALUES (109,'Technical Information Security');
INSERT INTO lesson(id, name) VALUES (110, 'Theoretical-Gaming Methods in Information Security');

INSERT INTO lesson_time VALUES (55,'10:05','8:30','MONDAY');
INSERT INTO lesson_time VALUES (56,'11:55','10:15','MONDAY');
INSERT INTO lesson_time VALUES (57,'13:45','12:10','MONDAY');
INSERT INTO lesson_time VALUES (58,'15:35','14:00','MONDAY');
INSERT INTO lesson_time VALUES (59,'17:30','15:55','MONDAY');
INSERT INTO lesson_time VALUES (60,'19:20','17:45','MONDAY');
INSERT INTO lesson_time VALUES (61,'10:05','8:30','TUESDAY');
INSERT INTO lesson_time VALUES (62,'11:55','10:15','TUESDAY');
INSERT INTO lesson_time VALUES (63,'13:45','12:10','TUESDAY');
INSERT INTO lesson_time VALUES (64,'15:35','14:00','TUESDAY');
INSERT INTO lesson_time VALUES (65,'17:30','15:55','TUESDAY');
INSERT INTO lesson_time VALUES (66,'19:20','17:45','TUESDAY');
INSERT INTO lesson_time VALUES (67,'10:05','8:30','WEDNESDAY');
INSERT INTO lesson_time VALUES (68,'11:55','10:15','WEDNESDAY');
INSERT INTO lesson_time VALUES (69,'13:45','12:10','WEDNESDAY');
INSERT INTO lesson_time VALUES (70,'15:35','14:00','WEDNESDAY');
INSERT INTO lesson_time VALUES (71,'17:30','15:55','WEDNESDAY');
INSERT INTO lesson_time VALUES (72,'19:20','17:45','WEDNESDAY');
INSERT INTO lesson_time VALUES (73,'10:05','8:30', 'THURSDAY');
INSERT INTO lesson_time VALUES (74,'11:55','10:15','THURSDAY');
INSERT INTO lesson_time VALUES (75,'13:45','12:10','THURSDAY');
INSERT INTO lesson_time VALUES (76,'15:35','14:00','THURSDAY');
INSERT INTO lesson_time VALUES (77,'17:30','15:55','THURSDAY');
INSERT INTO lesson_time VALUES (78,'19:20','17:45','THURSDAY');
INSERT INTO lesson_time VALUES (79,'10:05','8:30','FRIDAY');
INSERT INTO lesson_time VALUES (80,'11:55','10:15','FRIDAY');
INSERT INTO lesson_time VALUES (81,'13:45','12:10','FRIDAY');
INSERT INTO lesson_time VALUES (82,'15:35','14:00','FRIDAY');
INSERT INTO lesson_time VALUES (83,'17:30','15:55','FRIDAY');
INSERT INTO lesson_time VALUES (84,'19:20','17:45','FRIDAY');
INSERT INTO lesson_time VALUES (85,'10:05','8:30','SUNDAY');
INSERT INTO lesson_time VALUES (86,'11:55','10:15','SUNDAY');
INSERT INTO lesson_time VALUES (87,'13:45','12:10','SUNDAY');
INSERT INTO lesson_time VALUES (88,'15:35','14:00','SUNDAY');
INSERT INTO lesson_time VALUES (89,'17:30','15:55','SUNDAY');
INSERT INTO lesson_time VALUES (90,'19:20','17:45','SUNDAY');
INSERT INTO lesson_time VALUES (91,'10:05','8:30', 'SATURDAY');
INSERT INTO lesson_time VALUES (92,'11:55','10:15', 'SATURDAY');
INSERT INTO lesson_time VALUES (93,'13:45','12:10', 'SATURDAY');
INSERT INTO lesson_time VALUES (94,'15:35','14:00', 'SATURDAY');
INSERT INTO lesson_time VALUES (95,'17:30','15:55', 'SATURDAY');
INSERT INTO lesson_time VALUES (96,'19:20','17:45', 'SATURDAY');

/* MONDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (119,103,55,102,2);
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (120,104,56,101,3);
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (121,105,57,102,4);
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (122,106,58,102,5);

/* TUESDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (123, 107, 61, 98,  5)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (124, 108, 62, 100, 2)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (125, 109, 63, 99,  6)

/* WEDNESDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (126, 110, 70, 99, 2)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (127, 107, 71, 98, 4)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (128, 106, 72, 97, 3)

/* THURSDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (129, 104, 76, 103, 6)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (130, 103, 77, 100, 5)

/* FRIDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (131, 106, 82, 98, 4)

/* SATURDAY PLUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (132, 103, 94, 99, 3)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (133, 105, 95, 100, 2)

/* TUESDAY MINUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (134, 107, 61, 98,  5)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (135, 108, 62, 100, 2)

/* THURSDAY MINUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (136, 103, 76, 100, 2)
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (137, 104, 77, 102, 4)

/* FRIDAY MINUS */
INSERT INTO schedule_item(id, lesson_id, lesson_time_id, room_id, teacher_id) VALUES (138, 109, 82, 103, 4)

INSERT INTO schedule(id, week_type, study_group_id) VALUES (1, 'PLUS', 1);
INSERT INTO schedule(id, week_type, study_group_id) VALUES (2, 'MINUS', 1);

/* SCHEDULE PLUS */
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 119);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 120);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 121);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 122);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 123);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 124);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 125);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 126);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 127);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 128);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 129);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 130);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 131);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 132);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(1, 133);

/* SCHEDULE MINUS */
INSERT INTO schedule_items (schedule_id, items_id) VALUES(2, 134);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(2, 135);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(2, 136);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(2, 137);
INSERT INTO schedule_items (schedule_id, items_id) VALUES(2, 138);