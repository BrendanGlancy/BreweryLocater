<template>
  <div>
    <form>
      <div  class="form-element">
        <label for="name">Title:</label>
        <input id="name" type="text" v-model="newReview.name" />
      </div>
      <div  class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Beer</option>
          <option value="2">2 Beers</option>
          <option value="3">3 Beers</option>
          <option value="4">4 Beers</option>
          <option value="5">5 Beers</option>
        </select>
      </div>
      <div class="form-element">
        <label for="description">Review: </label>
        <textarea id="description" v-model="newReview.description"/>
      </div>
      <div>
        <button v-on:click.prevent="submitReview(newReview)" type="submit">Submit</button>
      </div>
    </form>
  
    <review-card v-for="review in reviews" v-bind:key="review.id" v-bind:review="review"/>
  </div>

</template>

<script>
import appServices from "../services/ApplicationServices";
import moment from "moment";
import ReviewCard from './ReviewCard.vue';

export default {
    name: "review",
    props: [
      'review'
    ], 
    components: {
      ReviewCard
    },
       

data(){
  return {
    reviews: [],
    isLoading: true,
    newReview: {
      name: "",
      description: "",
      rating: 0,
      userId: this.$store.state.user.id,
      beerId: this.$route.params.id,
      createDate: null
    }
  };
},
methods: {
  submitReview(newReview){
    newReview.createDate =  moment().format("YYYY-MMMM-do, h:mm:ss a");

  appServices.addReview(newReview).then(response =>{
        if(response.status === 201){
          alert(
            "Review successfully added"
          );
        }
  })
      
    },

},
created(){
  appServices.getReviewsByBeerID(this.$route.params.id).then(response => {
    this.reviews = response.data;
    this.isLoading = false;
  })
}
}

</script>

<style scoped>

</style>