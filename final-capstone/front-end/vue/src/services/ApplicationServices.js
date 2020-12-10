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
        return http.post(`/reviews`, review);
    },
    getUserByID(id){
        return http.get(`users/${id}`);
    }

}