<template>
    <nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand abs" href="#">Inholland Bank</a>
        <button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="collapseNavbar">
            <ul v-if="isLoggedIn" class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="//codeply.com">Codeply</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#myAlert" data-bs-toggle="collapse">Link</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item" v-if="!isLoggedIn">
                    <router-link to="/login" class="nav-link" >Login</router-link>
                </li>
                  <li class="nav-item" v-if="isLoggedIn">
                    <a v-on:click="logout" class="nav-link" >Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</template>

/template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "Navigation",
  computed: {
    ...mapGetters(["isLoggedIn"]),
    // ...mapGetters(["getUserRole"]),
  },
  methods: {
    logout() {
      localStorage.clear();
      this.$router.go("/login");
    },
  },
};
</script>