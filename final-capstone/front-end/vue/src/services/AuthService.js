/**************************************************************************************
* This file contains services used by the login front-end starter code
*
* DO NOT MODIFY THIS CODE! YOU MAY RENDER IT UNUSABLE!
*
* Consider putting any services required by your application in a different file.
***************************************************************************************/
import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }

}
