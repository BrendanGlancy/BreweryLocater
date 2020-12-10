<template>
    <div>
        <beer-details/>
        <review/>
    </div>
</template>
<script>
import BeerDetails from '../components/BreweryDetails'
import Review from '../components/Review.vue'
export default {
    components: {
        BeerDetails,
        Review
    }
}
</script>
<style scoped>
</style>