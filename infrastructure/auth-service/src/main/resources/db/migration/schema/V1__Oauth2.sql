CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `token_id` VARCHAR(255),
  `token` LONG VARBINARY,
  `authentication_id` VARCHAR(255) PRIMARY KEY,
  `user_name` VARCHAR(255),
  `client_id` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id` VARCHAR(255),
  `token` LONG VARBINARY,
  `authentication_id` VARCHAR(255) PRIMARY KEY,
  `user_name` VARCHAR(255),
  `client_id` VARCHAR(255),
  `authentication` LONG VARBINARY,
  `refresh_token` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id` VARCHAR(255),
  `token` LONG VARBINARY,
  `authentication` LONG VARBINARY
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `oauth_code` (
  `code` VARCHAR(255),
  `authentication` LONG VARBINARY
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `oauth_approvals` (
    `userId` VARCHAR(255),
    `clientId` VARCHAR(255),
    `scope` VARCHAR(255),
    `status` VARCHAR(10),
    `expiresAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `lastModifiedAt` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;