INSERT INTO ss.user_auth
(account_non_expire, credential_non_expire, enabled, non_lock, password, username)
VALUES
(true, true, true, true, '123', 'dao'),
(true, true, true, true, '123', 'qiu'),
(true, true, true, true, '123', 'zhang');


INSERT INTO ss.authority
(authority, description, method, name, uri)
VALUES
('book:read', '读书', 'GET', 'readBook', '/api/v1/book'),
('book:write', '写书', 'POST', 'writeBook', '/api/v1/book'),
('book:delete', '删书', 'DELETE', 'deleteBook', '/api/v1/book'),
('book:modify', '修书', 'PUT', 'modifyBook', '/api/v1/book');


insert into user_auth_authority
(user_auth_id, authority_id)
values
(1,1),
(1,2),
(1,3),
(1,4),
(2,1),
(3,1),
(3,3);


INSERT INTO ss.book (name, price) VALUES ('spring securitying精通到怀疑人声', 32.32);