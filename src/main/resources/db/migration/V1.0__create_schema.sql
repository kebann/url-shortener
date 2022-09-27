CREATE TABLE short_urls
(
    id           TEXT PRIMARY KEY,
    original_url TEXT      NOT NULL,
    title        TEXT,
    created_at   TIMESTAMP NOT NULL DEFAULT now()
);
