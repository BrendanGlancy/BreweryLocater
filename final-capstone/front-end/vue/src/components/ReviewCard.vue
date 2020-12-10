<template>
    <div class = "card">
        <h1>{{review.name}} Reviewed by:<span id="userName" v-if="review.userId">{{user.userName}}</span>
        <span id="userName" v-if="!review.userId">Anonymous</span>
        </h1>
        <h2>{{review.rating}}/5</h2>
        <h2>{{review.description}}</h2>
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
        appServices.getUserByID(this.review.id).then(response =>{
            this.user = response.data;
        })
    }
}
</script>

<style scoped>
/* .btn {
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
} */
</style>