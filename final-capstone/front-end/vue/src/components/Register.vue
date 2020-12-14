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
        class="username-input-box"
        placeholder="What shall we call you?"
        v-model="user.username"
        required
        autofocus
      />
      <br>
      <div class="password">
        <label for="password" class="sr-only">Password</label>
        <br>
        <input
          type="password"
          id="password"
          class="password-input-box"
          placeholder="Please...not password123"
          v-model="user.password"
          required
        />
        <input
        type="password"
        id="confirmPassword"
        class="confirm-password-input-box"
        placeholder="One more time please"
        v-model="user.confirmPassword"
        required
        />
      </div>
      <br>
      <br>
      <div class="brewer">
        <label class="brewer-label"> Are you a Brewer? </label>
        <div class="checkbox">
          <input 
          type="checkbox"
          id="brewer-checkbox"
          class="checkbox"
          v-on:change="(user.role == 'user' ? user.role = 'brewer' : user.role = 'user')"
          />
        </div>
        <label class="yes"> Yes</label>
      </div>
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
* {
  padding: 0px;
  margin: 0;
  box-sizing: border-box;
}

#background {
  height: 87vh;
}

.password {
  margin-top: 1rem;
}

h1 {
  margin: -5px 0px -20px -12px;
  font-size: 2rem;
}

.sr-only {
  margin-left: -.6rem;
}

form.form-register {
  position: absolute;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 16px;
  background-color: #f2f2f2;
  border-radius: 5px;
  padding-left: 30px;
} 

.username-input-box, .password-input-box, .confirm-password-input-box  {
  margin-top: .5rem;
  margin-left: -10px;
}

.have-account {
  text-decoration: none;
  color: #FF3C00;
}

.brewer {
  display: inline;
}
.checkbox {
  display: inline-block;
}

.have-account:hover {
  color: #311D00;
  text-decoration: underline;
}

.create-account {
  background-color: #FF3C00;
  border: none;
  font-size: 15px;
  padding: 3px;
  margin: 10px 0px 0px 10px;
  border-radius: 3px;
}

.create-account:hover {
  background-color: #311D00;
  color: white;
}
</style>
