CREATE TABLE IF NOT EXISTS quiz_log_event(
    id SERIAL PRIMARY KEY,
    quiz_id VARCHAR(255),
    quiz_user_id VARCHAR(255),
    question_id VARCHAR(255),
    choice_id VARCHAR(255),
    choice_text VARCHAR(255),
    question_text VARCHAR(255),
    score int,
    time_taken int
);