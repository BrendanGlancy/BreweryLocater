<template>
  <div id="app">
    
    <div id="nav">

      <router-link v-bind:to="{ name: 'home' }"><img id="logo" src="@/img/BrewFootball.png"/></router-link>
      <router-link class="nav-link" id="browse-brewery" v-bind:to="{ name: 'breweries' }">Browse<br>Breweries</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="browse-beer" v-bind:to="{ name: 'beers' }">Browse<br>Beers</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="browse-random" v-bind:to="{ name: 'home' }">Random<br>Beer</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class="nav-link" id="login-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
    </div>
    <router-view />
  </div>
</template>
<style scoped>
* {
  padding: 0px;
  margin: 0px;
  box-sizing: border-box;
}
#app {
  color: black;
  font-family: Arial, Helvetica, sans-serif;
}
#logo {
  width: 250px; 
  margin-bottom: -110px;
  margin-top: -15px;
}
#nav {
  background-image: url('./img/cle-sign-bg.jpg');
  position: relative;
  background-position:center;
  background-size: cover;
  background-attachment: fixed;
  position: fixed;
  text-shadow: 2px 2px 15px black;
  z-index: 999;
  display: flex;
  align-items: baseline;
  justify-content: space-around;
  flex-wrap: wrap;
  padding-bottom: 45px;
  margin-top: -20px; 
  width: 100%;
  margin-right: 60px;
}
.nav-link {
  background-color: transparent;
  text-decoration: none;
  font-weight: 700;
  text-align: center;
}

a {
  color: #FF3C00;
}

a:hover {
  color: #311D00;
  text-decoration: underline;
}

</style>
