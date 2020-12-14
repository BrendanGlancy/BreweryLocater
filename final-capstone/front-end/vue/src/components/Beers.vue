<template>
<div id="background">
<div class="beers">
    <h1 class="heading">All Our Beers</h1>
    <div class="beer-list">
        <beer-card class="card-space" v-for="beer in beers" v-bind:key="beer.name" v-bind:beer="beer"/>
    </div>
</div>
</div>
</template>
<script>
import BeerCard from "../components/BeerCard"
import applicationServices from "../services/ApplicationServices"
export default {
    props: ["beer"],
    components: { 
        BeerCard,
    },
    data() {
        return {
            beers: [],
            
        }
    },
    created() {
        applicationServices.getBeers().then(response => {
            this.beers = response.data
    })
    }
}
</script>
<style scoped>
* {
  padding: 0px;
  margin-left: -10px;
  margin-right: -10px;
  box-sizing: border-box;
}

div.beer-list {
    text-align: center;
}
div.beers {
    margin-left: 65px; margin-right: 65px;
    align-content: center;
}
div#body {
    margin-left: 25px; margin-right: 25px; margin-bottom: 50px;
    padding-bottom: 100px;
    text-align: center;
}
h1 {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
    height: 55vh;
    color: #ff7300;
    text-shadow: 2px 2px 15px black;
    font-size: 4rem;

    margin-bottom: 1rem;
    line-height: 1.2;
}
h1.heading {
    padding-top:25px;
}
.card-space:nth-child(odd) {
    background-color: rgb(243, 241, 241);
    border-radius: 12.5%;
    box-shadow: inset 0px 0px 10px #000;
}
.card-space:nth-child(even) {
    background-color: rgb(185, 185, 185);
    border-radius: 12.5%;
    box-shadow: inset 0px 0px 10px #000;
}
.card-space:hover {
    background-color: rgb(139, 139, 139);
    transition: 0.5s ease;
    box-shadow: inset 0px 0px 5px #000;
}

</style>