<template>
    <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal heading">Sign In</h1>
      <br>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <br>
      <div class="form-field">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Enter thou brewname"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <br>
      <div class="form-field">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Shh. Don't Tell Anyone!"
        v-model="user.password"
        required
      />
      </div>
      <br>
      <div class="form-field">
      <router-link class="need-account" :to="{ name: 'register' }">Need an account?</router-link> 
      <button class="submit" type="submit">Sign in</button>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
    data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
    
}
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
}

#login {
  height: 87vh;
 
}

form.form-signin {
  position: absolute;
  right: 0;
  margin: 5vh;
  max-width: 300px;
  padding: 16px;
  border-radius: 5px;
  padding-left: 30px;
} 

h1 {
  margin: -5px 0px -20px 0px;
  font-size: 2rem;
}

.form-signin {
  background-color: #f2f2f2;
  background-position: center;
  background-size: 100vh;
  backdrop-filter: blur(5px);
  box-shadow: inset 0px 0px 10px #000;
}

#username.form-control {
    font-size: 50;
    margin-left: .5rem;
    margin-top: 1rem;
}

#password.form-control {
  font-size: 50;
  margin-left: .7rem;
  margin-top: 1rem;
}

a.need-account {
  text-decoration: none;
  color: #FF3C00;

}

.need-account:hover {
  color: #311D00;
  text-decoration: underline;
}

.submit {
  background-color: #FF3C00;
  border: none;
  font-size: 15px;
  margin-left: 20px;
  width: 70px;
  padding: 3px;
  border-radius: 3px;
}

.submit:hover {
  background-color: #311D00;
  color: white;
}

.alert {
  margin-top: 1rem;
}
</style>