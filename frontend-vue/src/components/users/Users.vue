<template>
  <section v-if="isAdmin" class="table-accounts mx-4 p-4">
    <div class="container">
      <div class="button-container p-2 my-2">
        <button
          @click="this.$router.push('/home')"
          class="py-2 mx-2 btn btn-danger"
        >
          Go Back
        </button>
      </div>
      <h1 class="text-center text-muted">
        Here are all users who don't own a bank account yet
      </h1>
      <table class="table align-middle mb-0 bg-white shadow-sm">
        <thead class="bg-light">
          <tr>
            <th>id</th>
            <th>Username</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Account</th>
          </tr>
        </thead>
        <tbody v-if="users">
          <tr v-for="user in users" :key="user.id" :user="user">
            <td>
              <div class="d-flex align-items-center">
                <div class="ms-3">
                  <p class="text-muted mb-0">{{ user.id }}</p>
                </div>
              </div>
            </td>
            <td>
              <p class="fw-normal mb-1">{{ user.username }}</p>
            </td>
            <td>
              <span
                class="badge text-primary badge-success rounded-pill d-inline"
                >{{ user.firstname + " " + user.lastname }}</span
              >
            </td>
            <td>{{ user.email }}</td>
            <td>{{ user.phone }}</td>
            <td>
              <router-link to="/addaccount" class="btn btn-primary"
                >Add account</router-link
              >
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>
</template>



<script>
import axios from "../../axios-auth";
import { mapGetters } from "vuex";
export default {
  name: "Users",
  computed: {
    ...mapGetters(["isAdmin"]),
  },
  setup() {},
  data() {
    return {
      users: [],
    };
  },
  mounted() {
    let token = localStorage.getItem("token");
    axios
      .request({
        url: "users/getAllWithoutAccount",
        method: "get",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      })
      .then((response) => {
        this.users = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
};
</script>