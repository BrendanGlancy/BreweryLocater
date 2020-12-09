<template>
<div id="background">
    <div id="details">
        <h1>{{brewery.name}}</h1>
        <img class="company-logo" v-bind:src="this.brewery.breweryLogoUrl"/>
        <h3><span class="brewery-address" v-if="brewery.address" >{{brewery.address}}, </span>{{brewery.city}}</h3>
        <h3> {{brewery.website_url}} /// </h3>
        <h2 class="brewery-desc">{{brewery.description}}</h2>
        <h2 class="brewery-desc" v-if="!brewery.description">{{noDescReplacement}}</h2>
        <div id="beer-list">
            <h1>Beers from {{brewery.name}}</h1>
        <h3 v-for="beer in beers" v-bind:key="beer.id"> {{beer.name}} - <span class="beer-type">{{beer.type}}</span></h3>
    </div>
    </div>
</div>
</template>
<script>
import applicationServices from '../services/ApplicationServices'
export default {
    name: "brewery-details",
    data() {
        return {
            brewery: {
                id: 0,
                name: '',
                description: '',
                breweryLogoUrl: '',
                website_url: ''
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
    padding-top: 150px;
    text-align: center;
    background-color: white;
    margin-left: 65px; margin-right: 65px;
    padding-bottom: 15px; padding-left: 150px; padding-right: 150px;
}
div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-attachment: fixed;
    padding-bottom: 150px;
}
img.company-logo {
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
</style>