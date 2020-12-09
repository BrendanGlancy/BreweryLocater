<template>
<div id="background">
    <!-- <img id="cle-sign-bg" src='../img/cle-sign-bg.jpg'/> -->
    <div class="home">
        <div id="body">
            <h1 class="heading">Welcome to Brew Finder!</h1>
            <h3 class="subheading">A beer-lover's favorite website</h3>
        <h1>Popular Breweries</h1>
        <div class="loading" v-if="isLoading">
            <img src="../img/beerClink.gif" />
        </div>
        <div class="brewery-list">
            <brewery-card class="card-space" v-for="brewery in breweries" v-bind:key="brewery.name" v-bind:brewery="brewery"/>
        </div>
        </div>
    </div>
  </div>
</template>
<script>
import BreweryCard from './BreweryCard.vue'
import applicationServices from "../services/ApplicationServices"
export default {
    name: 'home',
    props: ["brewery"],
    components: { 
        BreweryCard,
    },
    data() {
        return {
            breweries: [],
            isLoading: true
        }
    },
    created() {
        applicationServices.getBreweries().then(response => {
            this.breweries = response.data
            this.isLoading = false;
    })
    }
}
</script>
<style scoped>
* {
    padding: 0%;
    margin: 0%;
}
div.home {
    background: white;
    margin-left: 65px; margin-right: 65px;
    align-content: center;
}
div#body {
    margin-left: 25px; margin-right: 25px; margin-bottom: 50px;
    padding-bottom: 100px;
    text-align: center;
}
h1 {
    text-align: center;
}

.card-space {

    color: black;
    text-decoration: none;
}

.card-space:hover {
    color: #311D00;
    text-decoration: underline;
}

.card-space:visited {
    color: gray;
}

h1.heading {
    padding-top:25px;
}
div.brewery-list {
    display: flex;
    justify-content: space-around;
    text-align: center;
    align-items: baseline;
    flex-wrap: wrap;
}

div.loading {
    text-align: center;
    float: center;
    z-index: 998;
}

div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-attachment: fixed;
    padding-top: 760px;
    top: -10px;
}

</style>