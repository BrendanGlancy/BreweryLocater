<template>
<div id="background">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal heading">Create Account</h1>
      <br>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <br>
      <label for="username" class="sr-only">Username</label>
      <br>
      <input
        type="text"
        id="username"
        class="input-box"
        placeholder="What shall we call you?"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <label for="password" class="sr-only">Password</label>
      <br>
      <input
        type="password"
        id="password"
        class="input-box"
        placeholder="Please...not password123"
        v-model="user.password"
        required
      />
      <br>
      <input
        type="password"
        id="confirmPassword"
        class="input-box"
        placeholder="One more time please"
        v-model="user.confirmPassword"
        required
      />
      <br>
      <router-link class="have-account" :to="{ name: 'login' }">Have an account?</router-link>
      <button class=" create-account btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
input {
    margin: 8px;
}

h1 {
  margin-top: -5px;
  margin-bottom: -10px;
  text-align: center;
}

form.form-register {
  top: 170px;
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
  border-radius: 5px;
} 

.input-box {
  margin-left: -1px;
}

.have-account {
  text-decoration: none;
  color: #FF3C00;
}

.have-account:hover {
  color: #311D00;
  text-decoration: underline;
}

.create-account {
  background-color: #FF3C00;
  border: none;
  font-size: 15px;
  margin-left: 30px;
  margin-top: 10px;
}

.create-account:hover {
  background-color: #311D00;
  color: white;
}


div#background {
    background-image: url('../img/cle-sign-bg.jpg');
    position: relative;
    background-position:center;
    background-size: cover;
    background-attachment: fixed;
    padding-top: 738px;
    top: -10px;
}
</style>
