import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {
    getBreweries() {
        return http.get('/breweries')
    },
    getBeers() {
        return http.get('/beers')
    },
    getBreweryByID(id) {
        return http.get(`/breweries/${id}`)
    },
    getBeerByID(id) {
        return http.get(`/beers/${id}`)
    },
    getBeerByBreweryID(id) {
        return http.get(`/breweries/${id}/beers`)
    },
    getReviewsByBeerID(beerId){
        return http.get(`/reviews/${beerId}`)
    },
    addReview(review){
        return http.post(`/reviews`, review)
    },
    getUserByID(id){
        return http.get(`users/${id}`)
    },
    createNewBrewery(brewery){
        return http.post(`/breweries`, brewery)
    },
    getAllUsers(){
        return http.get(`/users`)   
    },
    getBreweryByUserId(id){
        return http.get(`/users/${id}/breweries`)
    },
    deleteUser(id){
        return http.delete(`/users/${id}`)
    },
    deleteBrewery(id){
        return http.delete(`breweries/${id}`)
    },
    addNewBeer(beer){
        return http.post(`/beers`, beer)
    },
    deleteBeer(id){
        return http.delete(`beers/${id}`)
    },
    updateBeer(beer){
        return http.put(`/beers`, beer)
    },
    updateBrewery(brewery){
        return http.put(`/breweries`, brewery)
    }
}