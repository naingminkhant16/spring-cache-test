CREATE TABLE `students` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course` enum('FOUNDATION','HDB','HDIT','MAB') DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKe2rndfrsx22acpq2ty1caeuyw` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;