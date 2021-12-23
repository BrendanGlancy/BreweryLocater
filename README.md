# Brewery Finder website

'postgres backend, Vue frontend'

<table>
  <tr>
    <td align="center"><a href="https://github.com/BrendanGlancy"><img src="https://avatars.githubusercontent.com/u/61941978?v=4" width="100px;" alt=""/><br /><sub><b>Brendan Glancy</b></sub></a><br /><a title="Code">💻</a> <a title="Bug report">🐛</a></td>
    <td align="center"><a href="https://github.com/v-demichele"><img src="https://avatars.githubusercontent.com/u/62919992?v=4" width="100px;" alt=""/><br /><sub><b>Vince </b></sub></a><br /><a title="Code">💻</a> <a title="Bug report">🐛</a></td>
    <td align="center"><a href="https://github.com/markthebault"><img src="https://avatars.githubusercontent.com/u/3846664?v=4" width="100px;" alt=""/><br /><sub><b>Mark Thebault</b></sub></a><br /><a title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/diegodalvarez"><img src="https://avatars.githubusercontent.com/u/48641554?v=4" width="100px;" alt=""/><br /><sub><b>Diego Alvarez</b></sub></a><br /><a title="Code">💻🐛</a></td>
    <td align="center"><a href="https://github.com/rakeshbhat9"><img src="https://avatars.githubusercontent.com/u/11472305?v=4" width="100px;" alt=""/><br /><sub><b>Rakesh Bhat</b></sub></a><br /><a title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/Haizzz"><img src="https://avatars.githubusercontent.com/u/5275680?v=4" width="100px;" alt=""/><br /><sub><b>Anh Le</b></sub></a><br /><a title="Bug report">🐛</a></td>
  </tr>
</table>

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
