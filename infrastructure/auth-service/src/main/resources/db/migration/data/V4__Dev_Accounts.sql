INSERT INTO `user`
    (`id`, `email`, `password`, `first_name`, `last_name`)
VALUES
    (1, 'admin@test.com', '$2a$10$L4x8aZ3xlSdmc8h6M1JyoONkfMc4/z7JEEj65CLZQ24KDebNx4R5u', 'Admin', 'Test'),
    (2, 'user@test.com', '$2a$10$L4x8aZ3xlSdmc8h6M1JyoONkfMc4/z7JEEj65CLZQ24KDebNx4R5u', 'User', 'Test');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 1);