<template>
<div>
<router-link v-bind:to="{ name: 'brewery-details', params:{id: this.brewery.breweryId} }">
    <div id="card" data-aos="fade-down">
        <img class="company-logo" v-bind:src="this.brewery.breweryLogoUrl"/>
        <img class="company-logo" v-if="!brewery.breweryLogoUrl"  src="../img/404BeerNotFoundCrop.jpg">
        <a href="#" class="btn">{{this.brewery.name}}</a>
    </div>
</router-link>
    
</div>
</template>

<script>
//import applicationServices from '../services/ApplicationServices'

export default {
    props: ["brewery"], 
}
</script>
<style scoped>
.btn {
    font-family: Arial, Helvetica, sans-serif;
    font-size: .9rem;
    display: inline-block;
    background: #000;
    color: #fff;
    text-align: center;
    padding: 5px 5px;
    margin-top: 1rem;
    margin-bottom: 1rem;
    border-radius: 5px;
    box-shadow: inset 0px 0px 10px #000;
}

.btn:hover {
    opacity: 0.8;
}

a:hover, a:visited, a:link, a:active {
    text-decoration: none;
}

img.company-logo {
    width: 100%;
}

#card {
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    grid-template-columns: 1fr;
    grid-gap: 0rem;
    background-color: #d3d3d3;
    margin-bottom: 2rem;
    border-radius: 5px;
    box-shadow: inset 0px 0px 10px #000;
}
</style>