CREATE TABLE picture_evaluation (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    record_time DATE NOT NULL,
                                    image_url VARCHAR(255) NOT NULL,
                                    breed_recognition_result VARCHAR(100) NOT NULL,
                                    user_feedback int NOT NULL); -- 0 means no comments, 1 means good, 2 means bad

CREATE INDEX idx_breed_recognition_result ON picture_evaluation (breed_recognition_result);
