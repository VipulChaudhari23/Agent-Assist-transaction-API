create database agentassist;
use agentassist;
CREATE TABLE Accounts (
    account_number BIGINT PRIMARY KEY,
    account_type VARCHAR(50),
    balance DECIMAL(15, 2),
    customer_id BIGINT,
    creation_date TIMESTAMP
);
CREATE TABLE Transactions (
    transaction_id BIGINT PRIMARY KEY,
    customer_id BIGINT,
    account_number BIGINT,
    transaction_amount DECIMAL(15, 2),
    transaction_type VARCHAR(50),
    transaction_date_time TIMESTAMP,
    recipient VARCHAR(255),
    FOREIGN KEY (account_number) REFERENCES Accounts(account_number)
);

desc accounts;
desc transactions;
INSERT INTO Accounts (account_number, account_type, balance, customer_id, creation_date) VALUES
(1001, 'Saving', 5000.00, 1, '2023-01-15 10:00:00'),
(1002, 'CreditCard', 1000.00, 2, '2023-02-20 11:30:00'),
(1003, 'Saving', 7500.00, 3, '2023-03-25 09:15:00'),
(1004, 'CreditCard', 2000.00, 4, '2023-04-10 08:45:00'),
(1005, 'Saving', 3200.00, 5, '2023-05-12 14:20:00'),
(1006, 'Saving', 4600.00, 6, '2023-06-15 15:35:00'),
(1007, 'CreditCard', 2500.00, 7, '2023-07-10 16:50:00'),
(1008, 'Saving', 3800.00, 8, '2023-08-18 17:25:00'),
(1009, 'Saving', 6100.00, 9, '2023-09-10 18:15:00'),
(1010, 'CreditCard', 1100.00, 10, '2023-10-05 19:40:00'),
(1011, 'Saving', 5200.00, 11, '2023-11-08 20:10:00'),
(1012, 'CreditCard', 1500.00, 12, '2023-12-12 21:05:00'),
(1013, 'Saving', 7000.00, 13, '2024-01-15 22:45:00'),
(1014, 'CreditCard', 1900.00, 14, '2024-02-18 23:30:00'),
(1015, 'Saving', 5500.00, 15, '2024-03-22 10:15:00'),
(1016, 'Saving', 4200.00, 16, '2024-04-25 12:10:00'),
(1017, 'CreditCard', 2700.00, 17, '2024-05-28 14:50:00'),
(1018, 'Saving', 8000.00, 18, '2024-06-30 16:40:00'),
(1019, 'Saving', 5600.00, 19, '2024-07-22 18:35:00'),
(1020, 'CreditCard', 1300.00, 20, '2024-08-25 20:25:00');


INSERT INTO Transactions (transaction_id, customer_id, account_number, transaction_amount, transaction_type, transaction_date_time, recipient) VALUES
(2001, 1, 1001, 500.00, 'Saving', '2023-02-01 12:30:00', 'Store A'),
(2002, 2, 1002, 200.00, 'CreditCard', '2023-03-01 13:45:00', 'Store B'),
(2003, 3, 1003, 1500.00, 'Saving', '2023-04-01 15:10:00', 'Online C'),
(2004, 4, 1004, 100.00, 'CreditCard', '2023-05-01 16:25:00', 'Store D'),
(2005, 5, 1005, 300.00, 'Saving', '2023-06-01 10:30:00', 'Store E'),
(2006, 6, 1006, 450.00, 'Saving', '2023-07-01 11:45:00', 'Store F'),
(2007, 7, 1007, 600.00, 'CreditCard', '2023-08-01 13:10:00', 'Online G'),
(2008, 8, 1008, 700.00, 'Saving', '2023-09-01 14:25:00', 'Store H'),
(2009, 9, 1009, 800.00, 'Saving', '2023-10-01 15:40:00', 'Store I'),
(2010, 10, 1010, 200.00, 'CreditCard', '2023-11-01 16:55:00', 'Online J'),
(2011, 11, 1011, 300.00, 'Saving', '2023-12-01 10:05:00', 'Store K'),
(2012, 12, 1012, 400.00, 'CreditCard', '2024-01-01 11:15:00', 'Online L'),
(2013, 13, 1013, 900.00, 'Saving', '2024-02-01 12:25:00', 'Store M'),
(2014, 14, 1014, 200.00, 'CreditCard', '2024-03-01 13:35:00', 'Store N'),
(2015, 15, 1015, 750.00, 'Saving', '2024-04-01 14:45:00', 'Store O'),
(2016, 16, 1016, 350.00, 'Saving', '2024-05-01 15:55:00', 'Online P'),
(2017, 17, 1017, 220.00, 'CreditCard', '2024-06-01 10:20:00', 'Store Q'),
(2018, 18, 1018, 820.00, 'Saving', '2024-07-01 11:30:00', 'Store R'),
(2019, 19, 1019, 410.00, 'Saving', '2024-08-01 12:40:00', 'Online S'),
(2020, 20, 1020, 350.00, 'CreditCard', '2024-09-01 13:50:00', 'Store T'),
(2021, 1, 1001, 520.00, 'Saving', '2024-02-15 12:20:00', 'Store U'),
(2022, 2, 1002, 130.00, 'CreditCard', '2024-03-12 14:15:00', 'Online V'),
(2023, 3, 1003, 780.00, 'Saving', '2024-04-10 11:10:00', 'Store W'),
(2024, 4, 1004, 290.00, 'CreditCard', '2024-05-14 13:50:00', 'Online X'),
(2025, 5, 1005, 150.00, 'Saving', '2024-06-19 10:15:00', 'Store Y'),
(2026, 6, 1006, 530.00, 'Saving', '2024-07-22 11:55:00', 'Online Z'),
(2027, 7, 1007, 640.00, 'CreditCard', '2024-08-25 14:30:00', 'Store AA'),
(2028, 8, 1008, 860.00, 'Saving', '2024-09-28 15:20:00', 'Store BB'),
(2029, 9, 1009, 920.00, 'Saving', '2024-10-03 16:05:00', 'Online CC'),
(2030, 10, 1010, 170.00, 'CreditCard', '2024-11-05 10:40:00', 'Store DD');
