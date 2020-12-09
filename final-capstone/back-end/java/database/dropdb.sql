-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'final_capstone';
DROP DATABASE final_capstone;
