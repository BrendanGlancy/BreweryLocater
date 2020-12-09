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
    getBeerByBreweryID(id) {
        return http.get(`/breweries/${id}/beers`)
    }
}