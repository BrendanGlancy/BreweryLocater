<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }"><img id="logo" src="@/img/brew-logo.png"/></router-link>
      <router-link class="nav-link" id="browse-beers" v-bind:to="{ name: 'home' }">Browse Breweries</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="browse-beers" v-bind:to="{ name: 'home' }">Browse Beers</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="browse-beers" v-bind:to="{ name: 'home' }">Random Beer</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" id="browse-beers" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link class="nav-link" id="browse-beers" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
    </div>
    <router-view />
  </div>
</template>
<style scoped>
#app {
    background-color: black;
    color: white;
    font-family: 'Arial';
}
#logo {
    width: 250px;
    margin-bottom: -90px;
    float: left;
}
#nav {
    display: flex;
    align-items: baseline;
    justify-content: space-around;
    padding-bottom: 25px;
}
.nav-link {
  color: #FFDE59;
}

</style>
