<template>
        <div class="home">
            <div class="headings">
                <h1 class="heading">Welcome to Brew Finder!</h1>
                <h2 class="subheading">A beer-lover's favorite website</h2>
            </div>

            <div id="body">
                <h3 class="popular">Popular Breweries</h3>
                <div class="loading" v-if="isLoading">
                <img src="../img/beerClink.gif" />
                </div>

                <div class="brewery-list">
                <brewery-card class="card-space" v-for="brewery in breweries" v-bind:key="brewery.name" v-bind:brewery="brewery"/>
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
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.headings {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
    height: 55vh;
    color: #ff7300;
    text-shadow: 2px 2px 15px black;
}

.headings h1 {
    font-size: 4rem;
    margin-top: -2rem;
    margin-bottom: 1rem;
    line-height: 1.2;
}

.headings h2 {
    font-size: 2rem;
}

h3 {
    color: #ff7300;
    text-shadow: 2px 2px 15px black;
    display: flex;
    flex-direction: column;
    align-items: center;
    font-size: 3rem;
    margin-top: 11rem;
    margin-bottom: 2rem;
}

.brewery-list {
    padding-right: 25px;
    padding-left: 25px;
    display: flex;
    flex-wrap: wrap;
    grid-gap: 10px 200px;
    align-self: space-around;
    justify-content: space-around;
} 

div.loading {
    text-align: center;
    float: center;
    z-index: 998;
}
</style>