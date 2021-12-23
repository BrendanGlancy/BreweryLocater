# Brewery Finder website

---
<div align="center">
<img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" alt="Java" width="50" height="50"/>
<img src="https://github.com/devicons/devicon/blob/master/icons/html5/html5-original.svg" alt="HTML" width="50" height="50"/>
<img src="https://github.com/devicons/devicon/blob/master/icons/css3/css3-plain-wordmark.svg" alt="CSS" width="50" height="50"/>
<img src="https://github.com/devicons/devicon/blob/master/icons/javascript/javascript-original.svg" alt="JavaScript" width="50" height="50"/>
<img src="https://github.com/devicons/devicon/blob/master/icons/vuejs/vuejs-original-wordmark.svg" alt="VueJS" width="50" height="50"/>
<img src="https://github.com/devicons/devicon/blob/master/icons/postgresql/postgresql-original-wordmark.svg" alt="PostgreSQL" width="50" height="50"/>
</div>

---





## Co-authors

Thanks goes to these wonderful people:

[![All Contributors](https://img.shields.io/badge/all_contributors-5-orange.svg?style=flat-square)](#contributors-)
<table>
  <tr>
    <td align="center"><a href="https://github.com/BrendanGlancy"><img src="https://avatars.githubusercontent.com/u/61941978?v=4" width="100px;" alt=""/><br /><sub><b>Brendan Glancy</b></sub></a><br /><a title="Code">💻</a></a></td>
    <td align="center"><a href="https://github.com/Brandon-Eads"><img src="https://avatars.githubusercontent.com/u/72284442?v=4" width="100px;" alt=""/><br /><sub><b>Brandon Eads</b></sub></a><br /><a title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/v-demichele"><img src="https://avatars.githubusercontent.com/u/62919992?v=4" width="100px;" alt=""/><br /><sub><b>Vince DeMichele</b></sub></a><br /><a title="Code">💻</a> </a></td>
    <td align="center"><a href="https://github.com/JohnPatrickMullen"><img src="https://avatars.githubusercontent.com/u/70601152?v=4" width="100px;" alt=""/><br /><sub><b>John Mullen</b></sub></a><br /><a title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/Kautzmad"><img src="https://avatars.githubusercontent.com/u/46768512?v=4" width="100px;" alt=""/><br /><sub><b>Doug Kautzman</b></sub></a><br /><a title="Code">💻</a></td>
  </tr>
</table>

---
https://user-images.githubusercontent.com/61941978/147204062-a223f010-ca63-491e-8c85-9a6c0c0fb7cf.MOV

---

# Install

```
git clone https://github.com/BrendanGlancy/BreweryLocater.git
```

# Usage
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
