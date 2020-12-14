<template>
    <div id='admin-page'>
        <h1>New Brewery: Please Input Brewery Information</h1>
        <form>
            <table class='admin-table' id='brewery-add'>
                <thead></thead>
                <tbody>
            <div class="form-element">
                        <tr>
                <td><label for="name">Brewery Name:</label></td>
                <td><input id="name" type="text" v-model="newBrewery.name" required/></td>
                        </tr>
            </div>
            
            <div class="form-element">
                        <tr>
                <td><label for="address">Brewery Address:</label></td>
                <td><input id="address" type="text" v-model="newBrewery.address" required/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="city">City:</label></td>
                <td><input id="city" type="text" v-model="newBrewery.city" required/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="zipcode">Zipcode:</label></td>
                <td><input id="zipcode" type="text" v-model="newBrewery.zipcode" required/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="description">Description:</label></td>
                <td><textarea id="description" v-model="newBrewery.description" required/></td>
                        </tr>
            </div>
            
            <div class="form-element">
                        <tr>
                <td><label for="logo-url">Logo URL:</label></td>
                <td><input id="logo-url" type="text" v-model="newBrewery.breweryLogoUrl"/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="web-url">Website URL:</label></td>
                <td><input id="web-url" type="text" v-model="newBrewery.websiteUrl"/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="user">Brewer ID:</label></td>
                <td><input id="user" type="text" v-model="newBrewery.userId"/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="hours">Hours of Operation:</label></td>
                <td><input id="hours" type="text" v-model="newBrewery.hours"/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="lat">Lattitude:</label></td>
                <td><input id="lat" type="text" v-model="newBrewery.lat"/></td>
                        </tr>
            </div>
            <div class="form-element">
                        <tr>
                <td><label for="long">Longitude:</label></td>
                <td><input id="long" type="text" v-model="newBrewery.lon"/></td>
                        </tr>
            </div>
            <div>
                <button type="submit" class="submitBtn" onclick="window.location.reload();"
                 v-on:click.prevent="addNewBrewery()" >Submit</button>
            </div>
                </tbody>
            </table>
        </form>
        <div>
            <table class="admin-table" id="user-table">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>UserId</th>
                        <th></th>
                       <!--  <th>Number of breweries</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" v-bind:key="user.id" v-bind:user="user">
                        <td>{{user.username}}</td>
                        <td>{{user.id}}</td>
                        <td><button type="button" class="deleteBtn" v-on:click="deleteUser(user)">Delete</button></td>
                        <!-- <td>{{getBreweryByUserId(user.id)}}<td/> -->
                    </tr>
                    <p/>
                </tbody>
            </table>
        </div>
        <div>
            <table class="admin-table" id="brewery-table">
                <thead>
                    <tr>
                        <th>Brewery</th>
                        <th>BreweryID</th>
                        <th></th>
                       <!--  <th>Number of breweries</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="brewery in breweries" v-bind:key="brewery.id" v-bind:brewery="brewery">
                        <td>{{brewery.name}}</td>
                        <td>{{brewery.breweryId}}</td>
                        <td><button type="button" class="deleteBtn" v-on:click="deleteBrewery(brewery)">Delete</button></td>
                        <!-- <td>{{getBreweryByUserId(user.id)}}<td/> -->
                    </tr>
                    <p/>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import appServices from '../services/ApplicationServices'

export default {
    name: "brewery",
    props: [
        'brewery'
    ],
    components:{

    },

data(){
    return{
    users: [],
    breweries: [],
    newBrewery: {
      name: "",
      address: "",
      city: "",
      zipcode: "",
      phoneNumber: "",
      description: "",
      websiteUrl: "",
      breweryLogoUrl: "",
      userId: 0,
      hours: "",
      lat: "",
      lng: ""  
       }
    };
},
methods:{
    addNewBrewery(){
        appServices.createNewBrewery(this.newBrewery).then(response=>{
          if(response.status === 201){
          alert(
            "Brewery successfully added"
          );
        }  
        })
    },
    getBreweryByUserId(id){
        appServices.getBreweryByUserId(id).then(response =>{
            
            let counter

            response.data.forEach(element => {
                console.log(element)
                counter ++
            });
            
            return counter
        })
    },
    deleteUser(user) {
        if (confirm(`Are you sure you want to delete ${user.username}?`)) {
            appServices.deleteUser(user.id).then(response => {
                console.log(response)
                window.location.reload();
            })
        }
    },
    deleteBrewery(brewery){
        if (confirm(`Are you sure you want to delete ${brewery.name}?`)) {
            appServices.deleteBrewery(brewery.breweryId).then(response => {
                console.log(response)
                window.location.reload();
            })
        }
    }
},
created(){
    appServices.getAllUsers().then(response=> {
        this.users = response.data;
        }),

    appServices.getBreweries().then(response => {
         this.breweries = response.data;
     })
     }
}
</script>

<style scoped>
div#admin-page {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    
}

td {
    padding: 10px; 
    width: 150px;
    border-bottom-style: solid;
    border-bottom-width: 1px;
    border-bottom-color: rgb(201, 201, 201);
    
}
th {
    border-bottom-style: solid;
    border-bottom-width: 1px;
    border-bottom-color: rgb(201, 201, 201);
}
.submitBtn {
    text-align: center;
    margin: 15px;
}
.deleteBtn {
    background-color: rgb(197, 19, 19);
    color: white;
    
}
#user-table > tbody > tr:nth-child(even) {
    background-color: rgb(231, 231, 231);
}
#user-table > tbody > tr > td {
    border-bottom-color: white;
}
table {
    background-color: white;
    margin: 25px;
    padding: 15px;
    border-radius: 2.5%;
    border-collapse: collapse;
    box-shadow: inset 0px 0px 10px #000;
}
h1 {
    background-color: white;
    margin: 25px;
    padding: 15px;
    border-radius: 2.5%;
    border-collapse: collapse;
    box-shadow: inset 0px 0px 10px #000;

}
</style>