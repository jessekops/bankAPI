<template>
  <div class="container">
    <div v-if="isLoggedIn" class="hello">
      <div v-if="isAdmin" class="admin-menu">
        <h1 class="text-center">Welcome! {{ getUserName }}</h1>
        <h2 class="text-center text-info">Employee menu</h2>
        <div class="row">
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Manage accounts</h5>
                <p class="card-text">
                  This is quick access to manage the accounts
                </p>
                <a href="/accounts" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Manage Transactions</h5>
                <p class="card-text">
                  This is quick access to manage the transactions
                </p>
                <a href="/transactions" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-sm-4">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Manage users</h5>
                <p class="card-text">
                  This is quick access to manage the users
                </p>
                <a href="/users" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="admin-menu">
        <h2 class="text-center text-muted">Customer menu</h2>
        <div class="row">
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Deposit</h5>
                <p class="card-text">This is quick access to make a deposit</p>
                <router-link to="/deposit" class="btn btn-success text-white"
                  >Deposit</router-link
                >
              </div>
            </div>
          </div>
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Withdraw</h5>
                <p class="card-text">
                  This is quick access to make a withdrawal
                </p>
                <a href="/withdraw" class="btn btn-info text-white">Withdraw</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "HelloWorld",
  computed: {
    ...mapGetters(["isLoggedIn"]),
    ...mapGetters(["getUserName"]),
    ...mapGetters(["getUserRole"]),
    ...mapGetters(["isAdmin"]),
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
