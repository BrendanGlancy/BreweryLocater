<template>
  <div id="app">
    <router-link id="logo" v-bind:to="{ name: 'home' }"><img id="logo" src="./assets/BrewFootball.png"/></router-link>
    <nav class="navbar">
      <ul class="nav-links">
        <li><router-link id="browse-brewery" v-bind:to="{ name: 'breweries' }">Browse Breweries</router-link></li>
        <li><router-link id="browse-beer" v-bind:to="{ name: 'beers' }">Browse Beers</router-link></li>
        <li><router-link id="browse-random" v-bind:to="{ name: 'home' }">Random Beer</router-link></li>
        <li><router-link id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
        <li><router-link id="login-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link></li>
      </ul>
    </nav>
    <router-view />
  </div>
</template>

<style scoped>
* {
  padding: 0;
  margin: 0;
}

li {
  float: right;
}

ul {
  opacity: 75%;
  background-color: rgb(59, 64, 75);
  position: fixed;
  top: 1rem;
  width: 50%;
  border-top-left-radius: 30px;
  border-bottom-left-radius: 30px;
}

div#app {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url('assets/cle-sign-bg.jpg');
  position: relative;
  background-position:left top;
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  margin: -8px;
  margin-top: -20px;
  
}

.navbar {
  border-right: none;
  display: flex;
  justify-content: flex-end;
  background-color: transparent;
  margin-top: -3rem;
}

.nav-links {
  list-style-type: none;
}

a, li {
  display: block;
  color: white;
  padding: 16px;
  text-decoration: none;
  transition-duration: 500ms;
  border-radius: 5px;
}

a:hover {
  color: #FF3C00;
}

a:hover, a:visited, a:link, a:active {
    text-decoration: none;
}


li a:hover {
  background-color: #111;
}

#logo { 
  max-width: 33%;
}
</style>
