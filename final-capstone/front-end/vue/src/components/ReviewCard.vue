<template>
    <div class = "card">
        <div class="header">
            <h3>{{review.name}}  -  <span id="username" v-if="review.userId">{{user.username}}</span>
                <span id="username" v-if="!review.userId">Anonymous</span>
            </h3>
        </div>
        <div class="rating">
            <img
                src="../img/full-beer.png"
                v-bind:title="review.rating + ' Beer Review'"
                class="ratingStar"
                v-for="n in review.rating"
                v-bind:key="n"
            />
            <img
                src="../img/empty-beer.png"
                v-bind:title="review.rating + ' Beer Review'"
                class="ratingStar"
                v-for="n in 5 - review.rating"
                v-bind:key="n"
            />
        </div>
        <div class="review-desc">
        <img class ="mug" src='../assets/beermug.png'/>
        <p class="desc">{{review.description}}</p>
        </div>
    </div>
</template>

<script>
import appServices from "../services/ApplicationServices";

export default {
    props: ["review"], 
    data(){
       return{
           user: [],
       } 
    },
    created(){
        appServices.getUserByID(this.$store.state.user.id).then(response =>{
            this.user = response.data;
        })
    }
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
    margin-top: 10px;
} 
.header {
    margin-top: 10px;
}

div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.rating img {
  height: 100%;
}

.review-desc {
    display:flex;
    justify-content: space-between;
    align-items: center;
}
.mug {
    width: 75px;
    border-radius: 50%;
    margin-top: 50px; margin-right: 15px;
}

.desc {
    width: 100%;
    background-image: url('../assets/chat-bubble.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: 100% 150px;
    padding: 50px;
}

#username {
    color: rgb(0, 76, 190);
    font-size: 10pt;
}

</style>