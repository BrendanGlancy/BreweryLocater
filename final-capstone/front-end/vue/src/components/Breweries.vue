<template>
    <div id="background">
        <div class="breweries">
            <div class="heading">
                <h1>All Our Breweries</h1>
            </div>

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
* {
  padding: 0px;
  margin: 0px;
  box-sizing: border-box;
}

div.loading {
    text-align: center;
    float: center;
    z-index: 998;
}

/* .brewery-list {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
} */

.heading {
    font-size: 2rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    text-align: center;
    height: 40vh;
    color: #ff7300;
    text-shadow: 2px 2px 15px black;
}

/* .card-space {
    margin-left: 5px; margin-right: 5px;
    color: black;
    text-decoration: none;
} */

/* .card-space:hover {
    color: #311D00;
    text-decoration: underline;
}

.card-space:visited {
    color: gray;
} */

/* div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment: fixed;
} */

 .brewery-list {
    padding-right: 25px;
    padding-left: 25px;
    display: flex;
    flex-wrap: wrap;
    grid-gap: 10px 200px;
    align-self: space-around;
    justify-content: space-around;
} 

</style>