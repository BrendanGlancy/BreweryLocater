<template>
<router-link v-bind:to="{ name: 'brewery-details', params:{id: this.brewery.breweryId} }">
    <div id="card">
        <img class="company-logo" v-bind:src="this.brewery.breweryLogoUrl"/>
        <img class="company-logo" v-if="!brewery.breweryLogoUrl"  src="../img/404BeerNotFoundCrop.jpg">
        <h2>{{this.brewery.name}}</h2>
    </div>
</router-link>
</template>
<script>
export default {
    props: ["brewery"], 
}
</script>
<style scoped>
img.company-logo {
    width: 200px;
}
</style>