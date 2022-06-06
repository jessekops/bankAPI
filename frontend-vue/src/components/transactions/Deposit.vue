<template>
  <div class="container">
    <h1 class="text-center my-2 text-muted">
      Please select an account in the dropdown
    </h1>
    <div class="form-container">
      <form ref="form">
        <div class="input-group mx-0 text-center mb-3">
          <select
            class="w-75 text-center mx-0"
            :disabled="disable"
            v-model="selected"
          >
            <option
              v-for="account in accounts"
              v-bind:key="{ value: account.iban }"
            >
              {{ account.iban }}
            </option>
          </select>
          <button
            type="button"
            :disabled="!disable"
            @click="searchUser()"
            class="btn btn-success"
          >
            Search User
          </button>
        </div>
        <div class="input-group mb-3">
          <input disabled type="text" class="text-center form-control" />
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "../../axios-auth";
import { mapGetters } from "vuex";
export default {
  name: "Deposit",
  computed: {
    ...mapGetters(["isAdmin"]),
  },
  setup() {},
  data() {
    return {
      selected: "current",
      disable: false,
      accounts: [],
      userId: "",
    };
  },

  mounted() {
    let token = localStorage.getItem("token");
    axios
      .request({
        url: "users/getByUsername/" + localStorage.getItem("username"),
        method: "get",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json; charset=UTF-8",
          Authorization: `Bearer ${token}`,
        },
      })
      .then((response) => {
        this.userId = response.data.id;
        this.apiDropCall();
      })
      .catch((error) => {
        console.log(error);
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
  methods: {
    apiDropCall() {
      let token = localStorage.getItem("token");
      axios
        .request({
          url: "accounts/getByUserID/" + this.userId,
          method: "get",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json; charset=UTF-8",
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          console.log(response.data);
          this.accounts = response.data;
        })
        .catch((error) => {
          console.log(error);
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
  },
};
</script>