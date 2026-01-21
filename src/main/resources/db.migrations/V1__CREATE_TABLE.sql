CREATE TABLE IF NOT EXISTS tools (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    link VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tool_tags (
    tool_id BIGINT NOT NULL,
    tags VARCHAR(255),
    CONSTRAINT fk_tool_tags FOREIGN KEY (tool_id) REFERENCES tools(id)
);

