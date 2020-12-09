<template>
<div id="background">
<div class="breweries">
    <h1 class="heading">All Our Breweries</h1>
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
import BreweryCard from "../components/BreweryCard"
import applicationServices from "../services/ApplicationServices"
export default {
    props: ["brewery"],
    components: {
        BreweryCard,
    },
    data() {
        return {
            breweries: [],
            isLoading: true,
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
div.brewery-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    text-align: center;
    align-items: baseline;
}
div.breweries {
    padding-top: 150px;
    background: white;
    margin-left: 65px; margin-right: 65px;
    align-content: center;
}

div.loading {
    text-align: center;
    float: center;
    z-index: 998;
}

div#body {
    margin-left: 25px; margin-right: 25px; margin-bottom: 50px;
    padding-bottom: 100px;
    text-align: center;
}
h1 {
    color: black;
    text-align: center;
}
h1.heading {
    padding-top:25px;
}
div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-attachment: fixed;
    padding-bottom: 150px;
    top: -10px;
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

</style>