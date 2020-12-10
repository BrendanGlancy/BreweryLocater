<template>
<div id="background">
    <div id="details">
        <h1>{{beer.name}}</h1>
        <img class="beer-logo" v-bind:src="this.beer.imgUrl"/>
        <img class="beer-logo-404" v-if="beer.imgUrl == 'no img'" v-bind:src="this.brewery.breweryLogoUrl"/>
        <h3>{{beer.type}}<span class="beer-ibu" v-if="beer.ibu != 0" > - {{beer.ibu}} IBU</span> - {{beer.abv}} ABV</h3>
        <h3> {{brewery.website_url}}</h3>
        <h2 class="beer-desc" v-if="beer.info != 'No description'">{{beer.info}}</h2>
        <h2 class="beer-desc" v-if="beer.info == 'No description'">{{noDescReplacement}}</h2>
        <div id="brewery-info">
            <h1>Brewed by {{brewery.name}}</h1>
                <router-link v-bind:to="{ name: 'brewery-details', params:{id: beer.breweryId} }">
            <img class="company-logo" v-bind:src="this.brewery.breweryLogoUrl"/>  
                </router-link>
                <!-- here is where we want to include an option to add a review, including review and rating -->
            <review/>    
    </div>
    </div>
</div>
</template>
<script>
import applicationServices from '../services/ApplicationServices'
import Review from './Review.vue'

export default {
  components: { Review },
    name: "brewery-details",
    data() {
        return {
            beer: {
                id: 0,
                name: '',
                abv: 0,
                ibu: 0,
                type: '',
                info: '',
                imgUrl: '',
                breweryId: 0,
                active: true,
            },
            brewery: {
                id: 0,
                name: '',
                description: '',
                breweryLogoUrl: '',
                website_url: ''
            },
            noDescReplacement: "We can't find a description of this beer, but we're sure it's really great!"

        } 
    },
    created() {
        applicationServices.getBeerByID(this.$route.params.id).then(response => {
            this.beer = response.data
        }).then(breweryData => {
            applicationServices.getBreweryByID(this.beer.breweryId).then(response => {
            this.brewery = response.data
            console.log(breweryData)
        })
    })
    }   
}
</script>
<style scoped>
div#details {
    margin-top: 50px;
    text-align: center;
    background-color: white;
    margin-left: 65px; margin-right: 65px;
    padding-top: 15px; padding-bottom: 15px; padding-left: 150px; padding-right: 150px;
}
div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-attachment: fixed;
    padding-bottom: 150px; padding-top: 150px;
}
img.company-logo, img.beer-logo, img.beer-logo-404 {
    background-color: rgb(209, 209, 209);
    border-radius: 5%;
    width: 200px;
}
span.beer-type {
    color:rgb(65, 65, 65);
}
div#beer-info {
    padding-top: 15px;
    text-align: center;
}
h2.beer-desc {
    align-items: center;
}
</style>