INSERT INTO `willyfog_db`.`oauth_client` (`client_id`, `client_secret`, `redirect_uri`, `grant_types`, `scope`, `user_id`, `deleted_at`, `created_at`, `updated_at`) VALUES ('webclient', 'websecret', 'http://willyfog.com/login/callback', 'authorization_code client_credentials', NULL, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO `willyfog_db`.`oauth_client` (`client_id`, `client_secret`, `redirect_uri`, `grant_types`, `scope`, `user_id`, `deleted_at`, `created_at`, `updated_at`) VALUES ('mobileclient', 'mobilesecret', 'willyfog://login/callback', 'authorization_code client_credentials', NULL, NULL, NULL, DEFAULT, DEFAULT);