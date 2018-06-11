INSERT INTO `oauth_client_details`
    (`client_id`, `client_secret`, `scope`, `authorized_grant_types`,
     `web_server_redirect_uri`, `authorities`, `access_token_validity`,
     `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES
    ('clientId', 'clientSecret', 'read,write', 'password,refresh_token', null, null, 36000, 36000, null, true);

INSERT INTO `role` (`id`, `role`) VALUES (1, 'USER');
INSERT INTO `role` (`id`, `role`) VALUES (2, 'ADMIN');

INSERT INTO `user`
    (`id`, `email`, `password`, `first_name`, `last_name`)
VALUES
    (1, 'admin@test.com', 'password', 'Admin', 'Test'),
    (2, 'user@test.com', 'password', 'User', 'Test');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 1);