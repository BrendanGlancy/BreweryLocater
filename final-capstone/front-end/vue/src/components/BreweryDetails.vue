<template>
<div id="background">
    <div id="details">
        <h1>{{brewery.name}}</h1>
        <img class="company-logo" v-bind:src="this.brewery.breweryLogoUrl"/>
        <h3><span class="brewery-address" v-if="brewery.address" >{{brewery.address}}, </span>{{brewery.city}}</h3>
        <a v-bind:href="brewery.websiteUrl" target="_blank"><h3> {{brewery.websiteUrl}}</h3> </a>
        <h2 class="brewery-desc">{{brewery.description}}</h2>
        <h2 class="brewery-desc" v-if="!brewery.description">{{noDescReplacement}}</h2>
        <div id="beer-list">
            <h1>Beers from {{brewery.name}}</h1>
            <beer-card class="card-space" v-for="beer in beers" v-bind:key="beer.name" v-bind:beer="beer"/>
    </div>
    </div>
</div>
</template>
<script>
import applicationServices from '../services/ApplicationServices'
import BeerCard from './BeerCard'
export default {
    name: "brewery-details",
    components: {
        BeerCard
    },
    data() {
        return {
            brewery: {
                id: 0,
                name: '',
                description: '',
                breweryLogoUrl: '',
                websiteUrl: ''
            },
            beers: [],
            noDescReplacement: "We can't find a description of this brewery, but we're sure they're really great!"

        } 
    },
    created() {
        applicationServices.getBreweryByID(this.$route.params.id).then(response => {
            this.brewery = response.data
        })
        applicationServices.getBeerByBreweryID(this.$route.params.id).then(response => {
            this.beers = response.data
        })
    }
}
</script>
<style scoped>
div#details {
    margin-top: 100px;
    text-align: center;
    background-color: white;
    margin-left: 65px; margin-right: 65px;
    padding-bottom: 15px; padding-left: 150px; padding-right: 150px; padding-top: 15px;
}

img.company-logo {
    background-color: rgb(209, 209, 209);
    border-radius: 5%;
    width: 200px;
}
span.beer-type {
    color:rgb(65, 65, 65);
}
div#beer-list {
    padding-top: 15px;
    text-align: center;

}
h2.brewery-desc {
    
    align-items: center;
}

.card-space:nth-child(even) {
    background-color: rgb(221, 221, 221);
}
.card-space:hover {
    background-color: rgb(139, 139, 139);
}
</style>