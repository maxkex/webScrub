Assuming you already have a GitHub account.

1. **install GitHub** client on your PC.

2. **configure GitHub client**
- `git config --global user.name "yourgithubusername"`
- `git config --global user.email "youremail@example.com"`
 - check: `git config --global user.email`
- or 
  edit file: /home/your-username/.gitconfig
  
  git_home is usually located in the user home:
  
  On Unix/macOS): ~ or /home/username/.
  
  On Windows: C:\Users\username\.
	
3. **setup** GitHub global **list of files** to be **ignored** by Github commits.
- edit or create filein `/home/<your-username>/.gitignore_global`
- add folders and files to be ignored for all GitHub repositories:
   - `# Mac system files to ignore`
   - `.m2/`
   - `.ssh/`
   - `.DS_Store`
4. **clone repository**

5. **set your identity** for repository commits:
- `cd /path/to/your/repository`
- `git config user.name "maxkex"`
- `git config user.email  "mkebets@gmail.com"`

6. install **Java**
 - Download JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
 - Install following the installer instructions.
 - Set the JAVA_HOME environment variable
  - `export JAVA_HOME=$(/usr/libexec/java_home)`
  - `export PATH=$JAVA_HOME/bin:$PATH`
  - verify your Java version: `java -version`
    
8. install **maven**
 - assuming that Homebrew is installed on your mac:
 - `brew install maven`
 - verify Maven version: `mvn -v`
   
9. install [**Chrome Driver**](https://developer.chrome.com/docs/chromedriver/downloads) and Chrome Browser ([Chrome browser test versions](https://googlechromelabs.github.io/chrome-for-testing/))

10. install [**Visual Studio Code**](https://code.visualstudio.com)

11. install **Visual Studio Code Extensions**
 - Java (Oracle Java Extention for Visual Studio Code)
 - Language Support for Java
 - Debugger for Java
 - Extension Pack for Java
 - Project Manager for Java
 - Maven for Java
 - Reload
 - * GitHub Copilot
 - * Github Copilot Chat

12. * setup [**coPilot**](https://docs.github.com/en/copilot/using-github-copilot/getting-started-with-github-copilot)
   
13. install **Tesseract**
 - `brew install tesseract`
 - `tesseract --version`
 - to check location: `which tesseract`
