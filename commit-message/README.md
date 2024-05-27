# The Anatomy of a Commit Message

## Basic:

`git commit -m <message>`


## Detailed:

`git commit -m <title> -m <description>`


Make it clear _why_ that change was made, and note if it may be crucial for the functionality or not.  
  
See the differences below:

1. `git commit -m 'Add margin'`
2. `git commit -m 'Add margin to nav items to prevent them from overlapping the logo'`

## How to write good commit messages?

- In Git, commit messages typically follow a conventional format, and there are several prefixes or commands that can be used to indicate the type of changes made in the commit. 
- Here are some commonly used prefixes:

	**feat**: Introduces a new feature or enhancement.

	**fix**: Fixes a bug or issue.

	**refactor**: Refactors the codebase without changing its external behavior.

	**test**: Adds or modifies tests.

	**docs**: Updates documentation.

	**style**: Changes formatting, white-space, etc., without affecting the code logic.

	**chore**: Changes that don't modify src or test files, such as updating build tasks, package manager configuration, etc.

	**perf**: Improves performance.

**Notes :** These prefixes are followed by a colon and a brief description of the changes made in the commit. For example:

	feat(user): Add user authentication

	fix(bug): Fix login issue

	refactor(database): Optimize query performance

#### Example:
```bash
git commit -m "feat(user): Implement CRUD operations for user module

- Created User entity with fields: id, name, email, password, and about
- Created UserDto class for data transfer between application and database
- Implemented UserRepository interface with methods for database operations
- Created UserServiceImpl class implementing UserService interface
- Implemented methods for creating, retrieving, updating, and deleting users
- Added exception handling for resource not found scenarios"
```

**feat(user) :** means -

- In the context of Git commit messages, feat(user) is a conventional prefix that indicates that the commit is related to a new feature or enhancement in the user module. 
- The prefix feat stands for "feature," and it's followed by the name of the module or component being modified. Here's a breakdown of the commit message:

	**feat**: Indicates that the commit introduces a new feature or enhancement.
	**(user)**: Specifies the module or component being modified, in this case, the user module.
	**Implement CRUD operations for user module**: Provides a brief description of the changes made in the commit.

The commit message should be concise and informative, providing a clear overview of the changes made. It's also important to follow the conventions of your project or organization for commit messages.

## git-commit-template

```text
# Title: Summary, imperative, start upper case, don't end with a period
# No more than 50 chars. #### 50 chars is here:  #

# Remember blank line between title and body.

# Body: Explain *what* and *why* (not *how*). Include task ID (Jira issue).
# Wrap at 72 chars. ################################## which is here:  #

# At the end: Include Co-authored-by for all contributors. 
# Include at least one empty line before it. Format: 
# Co-authored-by: name <user@users.noreply.github.com>
#

# How to Write a Git Commit Message:
# https://chris.beams.io/posts/git-commit/ 
#
# 1. Separate subject from body with a blank line
# 2. Limit the subject line to 50 characters
# 3. Capitalize the subject line
# 4. Do not end the subject line with a period
# 5. Use the imperative mood in the subject line
# 6. Wrap the body at 72 characters
# 7. Use the body to explain what and why vs. how

```



A good commit consists of two parts -
1. Commit message
2. The meat of the commit (the actual change)
- Every code code-change should be atomic.(as more and as self contained) 
```
For example - 
Add controller for widget(it inlcudes test-case code also)

Solution-1:
~ git checkout feature/ticket-42-unicorn widget
~ git merge --squash private/unicorn-widget
~ git commit -v <message>
(it will make all commits into one commit)

Solution-2:
~ git checkout feature/ticket-42-unicorn widget
~ git merge --squash private/unicorn-widget
~ git reset
(it will make all commit changes uncommit)
```


## Seven rules for a good commit message -


1. Limit the subject line to 50 characters.
2. Capitalize only the first character of the subject line.
3. Don't put a period at the end of the subject line (don't use dot[.])
4. Put a blank line between the body and the subject 
5. Wrap the body in 72 characters.
6. Use the imperative mood (write message like you are giving command)
7. Use the body to explain what and why not how. (Mention which component was changed)

# References
1. [https://www.conventionalcommits.org/en/v1.0.0/](https://www.conventionalcommits.org/en/v1.0.0/)
