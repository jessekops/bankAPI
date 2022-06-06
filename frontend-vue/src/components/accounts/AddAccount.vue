<template>
  <section :v-if="isAdmin" class="table-accounts mx-4 p-4">
    <div class="container">
      <div class="button-container p-2 my-2">
        <button
          @click="this.$router.push('/accounts')"
          class="py-2 mx-2 btn btn-danger"
        >
          Go Back
        </button>
      </div>
      <div class="form-container">
        <form ref="form">
          <div class="input-group mb-3">
            <span class="input-group-text">Search for user</span>
            <input
              :disabled="!disable"
              type="text"
              v-model="username"
              class="form-control"
            />
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
            <input
              disabled
              type="text"
              :placeholder="placeHolder"
              class="text-center form-control"
            />
          </div>
          <div class="mx-0 text-center text-danger">
            {{ errMsg }}
          </div>
        </form>
      </div>
      <div class="form-container">
        <h2 class="mt-3 mt-lg-5">Create an Account</h2>
        <h5 class="mb-4"></h5>
        <form id="mainForm">
          <div class="input-group mb-3">
            <span class="input-group-text">Absolute limit</span>
            <input
              @keypress="isNumber($event)"
              :disabled="disable"
              v-model="abs"
              required=""
              type="text"
              class="required form-control"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">Accounttype</span>
            <div class="">
              <select :disabled="disable" v-model="selected">
                <option
                  v-for="option in options"
                  v-bind:key="{ value: option.value, text: option.text }"
                >
                  {{ option.text }}
                </option>
              </select>
            </div>
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">Balance</span>
            <input
              @keypress="isNumber($event)"
              :disabled="disable"
              v-model="balance"
              required=""
              type="text"
              class="form-control"
            />
          </div>
          <div class="input-group mt-4">
            <button class="btn btn-primary" @click="addAccount()">
              Create Account
            </button>
            <button
              type="button"
              class="btn btn-danger"
              @click="this.$router.push('/accounts')"
            >
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "../../axios-auth";
import { mapGetters } from "vuex";
export default {
  name: "AddAccount",
  computed: {
    ...mapGetters(["isLoggedIn"]),
    ...mapGetters(["isAdmin"]),
  },
  data() {
    return {
      selected: "current",
      options: [
        { text: "current", value: "current" },
        { text: "savings", value: "savings" },
      ],
      username: "",
      placeHolder: "",
      fetchedUser: "",
      balance: "",
      ownerId: "",
      abs: "",
      errMsg: "",
      disable: true,
    };
  },

  //don't allow anything but numbers in the input method
  methods: {
    isNumber: function (evt) {
      evt = evt ? evt : window.event;
      var charCode = evt.which ? evt.which : evt.keyCode;
      if (
        charCode > 31 &&
        (charCode < 48 || charCode > 57) &&
        charCode !== 46
      ) {
        evt.preventDefault();
      } else {
        return true;
      }
    },
    searchUser() {
      console.log(this.username);
      axios
        .get("users/getByUsername/" + this.username)
        .then((res) => {
          this.placeHolder = res.data.firstname + " " + res.data.lastname;
          this.ownerId = res.data.id;
          this.fetchedUser = JSON.stringify(res.data);

          console.log(this.fetchedUser);
          this.disable = false;
        })
        .catch(function (error) {
          // this.errMsg = "User not found";
          console.log(error);
        });
    },
    //adduser method

    addAccount() {
      const data = JSON.stringify({
        accountType: this.selected.valueOf(),
        ownerId: this.ownerId,
        balance: parseFloat(this.balance),
        absLimit: parseFloat(this.abs),
        active: true,
      });
      let token = localStorage.getItem("token");
      let config = {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`,
        },
      };
      axios
        .post("accounts", data, config)
        .then(function (response) {
          this.$router.push("/accounts");
          console.log(response);
        })
        .catch(function (error) {
          console.log(data);
          console.log(error);
        });
    },
  },
};
</script>
