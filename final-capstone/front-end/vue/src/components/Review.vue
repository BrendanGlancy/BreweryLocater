<template>
  <div>
    <form v-if="this.$store.state.user.id > 0">
      <div  class="form-element">
        <div class="form">
          <div class="col-25">
            <label for="name">Title:</label>
          </div>
          <div class="col-75">
            <input id="name" type="text" v-model="newReview.name" required/>
          </div>
          <div class="col-25">
            <label for="rating">Rating:</label>
          </div>
          <div class="col-75">
          <select id="rating" v-model.number="newReview.rating" required>
            <option value="1">1 Beer</option>
            <option value="2">2 Beers</option>
            <option value="3">3 Beers</option>
            <option value="4">4 Beers</option>
            <option value="5">5 Beers</option>
          </select>
          </div>
          <div class="col-25">
            <label for="description">Review: </label>
          </div>
          <div class="col-75">
            <textarea id="description" v-model="newReview.description" required/>
          </div>
          <button class="submitBtn" onclick="window.location.reload();" v-on:click.prevent="submitReview()" type="submit">Submit</button>
      </div>
      </div>
    </form>
 
    <div class="reviews">
      <review-card v-for="review in reviews" v-bind:key="review.id" v-bind:review="review"/>
  </div>
  </div>
  

</template>

<script>
import appServices from "../services/ApplicationServices";
/* import moment from "moment";
 */
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
      /* createDate: null */
    }
  };
},
methods: {
  submitReview(){
    /* newReview.createDate =  moment().format("YYYY-MMMM-do, h:mm:ss a"); */

  appServices.addReview(this.newReview).then(response =>{
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

label {
  padding: 12px 12px 12px 0;
  display: inline;
}

.form-element {
  height: 220px;
  background-color: #ffffff;
  width: auto;
  
  
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
  
  
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  
}

.submitBtn {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
  margin-bottom: 10px;
  box-shadow: inset 0px 0px 8px #000;
  font-size: 14px;
  text-shadow: 2px 2px 3px black;
  transition: 300ms;
}
.submitBtn:hover{
    box-shadow: inset 0px 0px 10px #000;
    border-radius: 6px;
    background-color: red;
    font-size: 18px;

}

.reviews {
  margin-top: 15px;
}
#name{
  box-shadow: inset 0px 0px 3px #000;
}
#rating{
  box-shadow: inset 0px 0px 3px #000;
}
#description{
  box-shadow: inset 0px 0px 3px #000;
}


@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }

}

</style>