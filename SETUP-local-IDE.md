Assuming you already have a GitHub account.

1. install GitHub client on your PC.

2. configure GitHub client
- `git config --global user.name "yourgithubusername"`
- `git config --global user.email "youremail@example.com"`
 - check: `git config --global user.email`
- or 
  edit file: /home/your-username/.gitconfig
  
  git_home is usually located in the user home:
  
  On Unix/macOS): ~ or /home/username/.
  
  On Windows: C:\Users\username\.
	
3. setup GitHub global list of files to be ignored by Github commits.
- edit or create filein `/home/<your-username>/.gitignore_global`
- add folders and files to be ignored for all GitHub repositories:
   - `# Mac system files to ignore`
   - `.m2/`
   - `.ssh/`
   - `.DS_Store`
4. clone repository

5. set your identity for repository commits:
- `cd /path/to/your/repository`
- `git config user.name "maxkex"`
- `git config user.email  "mkebets@gmail.com"`
