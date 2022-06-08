<template>
  <div v-if="isLoggedIn" class="container">
    <h1 class="text-center my-2 text-muted">
      Please select an account in the dropdown
    </h1>
    <div class="form-container">
      <form ref="form">
        <div class="input-group mx-0 text-center mb-3">
          <select
            @change="onChange($event)"
            class="w-100 text-center mx-0"
            :disabled="disable"
            v-model="selected"
          >
            <option :value="null" disabled>Select Account</option>
            <option
              v-for="account in accounts"
              v-bind:key="{ value: account.iban }"
            >
              {{ account.iban }}
            </option>
          </select>
        </div>
        <div class="input-group mb-3">
          <input
            disabled
            selected
            hidden
            type="text"
            class="text-center form-control"
          />
        </div>
      </form>
    </div>
    <div class="">
      <h1 v-if="balance" class="text-center text-muted">
        Current account balance: €{{ balance }}
      </h1>
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
    ...mapGetters(["isLoggedIn"]),
  },
  setup() {},
  data() {
    return {
      selected: "current",
      disable: false,
      accounts: [],
      userId: "",
      balance: "",
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
    onChange(event) {
      let token = localStorage.getItem("token");
      axios
        .request({
          url: "accounts/getByIban/" + event.target.value,
          method: "get",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json; charset=UTF-8",
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          this.balance = response.data.balance;
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => (this.loading = false));
    },
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