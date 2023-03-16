select setval('vehicle_sequence', 1000);
select setval('person_sequence', 1000);

insert into person (id, dbob, name)
values (1, '2000-01-01', 'John Doe');


---

insert into vehicle (id, model, brand)
values (1, 'Insignia', 'Opel');
insert into vehicle (id, model, brand)
values (2, 'A4', 'Audi');
insert into vehicle (id, model, brand)
values (3, 'Fiorino', 'Fiat');

---


insert into rental (id, discount, end_date, start_date, person_id, vehicle_id)
values (1, 0, '2023-03-15 12:15:00', '2023-03-14 10:00:00', 1, 1);
insert into rental (id, discount, end_date, start_date, person_id, vehicle_id)
values (2, 0, '2023-03-15 12:15:00', '2023-03-14 10:00:00', 1, 2);

