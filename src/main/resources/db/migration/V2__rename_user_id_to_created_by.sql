-- Step 1: Drop the existing foreign key constraint
ALTER TABLE todos DROP CONSTRAINT fk_todos_user;

-- Step 2: Rename the user_id column to created_by
ALTER TABLE todos RENAME COLUMN user_id TO created_by;

-- Step 3: Recreate the foreign key constraint with the new column name
ALTER TABLE todos ADD CONSTRAINT fk_todos_user FOREIGN KEY (created_by) REFERENCES users(id);