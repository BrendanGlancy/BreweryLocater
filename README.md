# Brewery Finder website

'postgres backend, Vue frontend'

Vercle hosting is a work in progress...

Co-authored-by: name <kautzmad63@gmail.com> 

Co-authored-by: another-name <johnpatrickmullen88@gmail.com>

Co-authored-by: another-name <VinceDeMichele@gmail.com>

Co-authored-by: another-name <beads1997@gmail.com>


to run this script

Inside the /database/ directory you will find an executable Bash script (.sh file)

To run: 
```console
cd <project-root>/database/ chmod u+r+x create_capstone-db.sh ./create_capstone-db.sh
```
above ^ works on MacOS

using Ubuntu you can run this by doing a

this might also work on the tech elevator laptops, sh ./create_capstone-db.sh

# After database population

Start the java server

```console
cd <project-root>/application-server/
javac application-server
java application-server
```

# After server is started

```console
cd <project-root>/vue/
npm install
npm run serve
```
Now you can interact with this full stack application
