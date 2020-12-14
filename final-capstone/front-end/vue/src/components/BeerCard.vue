<template>

<div id="card" @mouseover="showBeer = true" @mouseleave="showBeer = false">

    <div v-if="showBeer == false">
        <img>
    </div>

    <div class="middle" v-else-if="showBeer != false">
        <img v-if="this.beer.imgUrl == 'no img'" v-bind:src="this.brewery.breweryLogoUrl" alt="Avatar" class="image" >
        <img v-if="this.beer.imgUrl != 'no img'" v-bind:src="this.beer.imgUrl"  alt="Avatar" class="image">
    </div>

    <router-link v-bind:to="{ name: 'beer-details', params:{id: this.beer.id} }">
        <h4 class="brewery-name" > {{this.brewery.name}} </h4>
        <h3>{{this.beer.name}} - <span class="beer-type"> {{this.beer.type}} </span></h3>
        <h5> {{this.beer.abv}} ABV <span v-if="beer.ibu"> - {{this.beer.ibu}} IBU </span></h5>
        <h4 class="beer-info" v-if="beer.info != 'No description'" > {{this.beer.info}} </h4>
        <h4 class="beer-info" v-if="beer.info == 'No description'" > {{noDesc}} </h4>
    </router-link>

    <div class="tooltip" v-if="this.$store.state.userId === this.brewery.usedId">

        <button type="submit" class="brewerButton" v-on:click.prevent="deleteBeer(this.beer.id)"
                onclick="window.location.reload();" >
                <span class="tooltiptext">Delete Beer</span>
                <img src="../assets/delete-icon.png" id="deleteButton"/>
        </button>

    </div>

    <div class="tooltip" v-if="this.$store.state.userId === this.brewery.usedId">

        <button type="submit" class="brewerButton" id="show-update-beer-form"
                v-on:click.prevent="showForm = true" v-if="showForm === false">
            <span class="tooltiptext">Update Beer Form</span>
            <img src="../assets/edit-icon.png" id="editButton"/>
        </button>

    </div>

    <div class="updateBeerForm" v-if="showForm === true">

        <h1>Update Beer Form</h1>

        <form>

            <label for="beerName">Name</label>
            <input type="text" id="beerName" value="beer.name" v-model="updatedBeer.name" required/>
                                <!-- use value to display the current information -->
            <label for="ABV">ABV</label>
            <input type="text" id="ABV" value="beer.name" v-model="updatedBeer.abv"/>

            <label for="IBU">IBU</label>
            <input type="text" id="IBU" value="beer.name" v-model="updatedBeer.ibu"/>

            <label for="Type">Type</label>
            <input type="text" id="type" value="beer.name" v-model="updatedBeer.type" required/>

            <label for="Type">Info</label>
            <input type="text" id="Info" value="beer.name" v-model="updatedBeer.info" required/> 

            <label for="Type">Beer Image</label>
            <input type="text" id="Info" value="beer.name" v-model="updatedBeer.imgUrl"/>

            <label for="acitve">Active Status</label>   <!-- where does the v-model go? -->
            <select id="active" name="active" >
            <option value="True">Yes</option>
            <option value="False">No</option>
            </select>
        
            <div  class="show-form-button">
                <button
                    id="show-form-button"
                    href="#"
                    v-on:click.prevent="showForm = false"
                    v-if="showForm === true"
                    >
                    Hide Form
                </button>
            </div>

            <div class="submit-update-button">
                <button type="submit" id="submitButton" onclick="window.location.reload();"
                 v-on:click.prevent="updateBeer(updatedBeer)">Submit Beer Update</button>
            </div>

        </form>

    </div>

</div>

</template>

<script>
import applicationServices from '../services/ApplicationServices'
export default {
    props: ["beer"], 
    data() {
        return { 
            showBeer: false,
            showForm: false,
            brewery: {
                id: 0,
                name: '',
                description: '',
                breweryLogoUrl: '',
                website_url: ''
            },
            updatedBeer:{
                id: this.beer.id,
                name: "",
                abv: 0,
                ibu: 0,
                type: "",
                info: "",
                imgUrl: "",
                isActive: true,
                breweryId: this.beer.breweryId
            },
            noDesc: 'We can\'t find any info on this beer, but we\'re sure it\'s great!'
        }
    },
    methods: {
        updateBeer(beer){
            applicationServices.updateBeer(beer).then(response=>{
            if(response.status === 201){
            alert("Beer successfully updated");
            }  
            })
        },
        deleteBeer(id){
            if(confirm(`Are you sure you want to delete this beer?`)){
            applicationServices.deleteBeer(id).then(response =>{
                if(response.status === 201){
                    alert("Beer deleted")
                }
            })
        }
     }
    },
    created() {
        applicationServices.getBreweryByID(this.beer.breweryId).then(response => {
            this.brewery = response.data
        })
    }
}
</script>

<style scoped>
img.company-logo {
    width: 200px;
}
div#card {
    margin-left: 150px; margin-right: 150px;
   
}
span.beer-type {
    color:rgb(65, 65, 65);
}
.brewery-name {
    color:rgb(65, 65, 65);
    margin-bottom: -10px; padding-top: 25px;
}
.beer-info {
    padding-bottom: 35px;
}
h5 {
    margin-top: -10px; margin-bottom: -5px;
}
a {
    text-decoration: none;
    color: inherit;
}
a:hover {
    background-color: gray; 
    box-shadow: inset 0px 0px 10px 10px #000;

}

.container {
  position: relative;
  width: 50%;
}

.image {
  width: 17%;
  height: 17%;
  align-items: center;
}

.overlay {
  transition: 1s ease;
  background-color: #008CBA;
}

.container:hover .overlay {
  opacity: 1;
}

div.card:nth-child(even) {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    text-align: center;
    align-items: baseline;
    background-color: rgb(221, 221, 221);
}

#deleteButton, #editButton{
    border-radius: 50%;
    width: 5%;
    height: 5%;
}

/* Tooltip container */
.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black; /* If you want dots under the hoverable text */
}

/* Tooltip text */
.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: black;
  color: #fff;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
 
  /* Position the tooltip text - see examples below! */
  position: absolute;
  z-index: 1;
}

/* Show the tooltip text when you mouse over the tooltip container */
.tooltip:hover .tooltiptext {
  visibility: visible;
}

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

#submitButton {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

#submitButton:hover {
  background-color: #45a049;
}

.updateBeerForm {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.updateBeerForm h1 {
    text-align: center;
}
</style>

