<template>
    <div id="card">
        <h3>{{this.beer.name}} - <span class="beer-desc"> {{this.beer.type}} </span></h3>
        <h4> {{this.beer.info}} </h4>
    </div>
</template>
<script>
export default {
    props: ["beer"], 
}
</script>
<style scoped>
img.company-logo {
    width: 200px;
}
div#card {
    margin-left: 150px; margin-right: 150px;
}

</style>