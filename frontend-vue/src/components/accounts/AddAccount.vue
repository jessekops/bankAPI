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
        <form v-on:submit.prevent="addAccount" ref="form">
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
              required="required"
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
          <div class="input-group mb-3">
            <span class="input-group-text">Pincode</span>
            <div class="input-wrapper">
              <div>
                <div class="input-group">
                  <input
                    :disabled="disable"
                    v-model.number="pin_0"
                    v-on:keyup.right="pin_focus('pin_1')"
                    v-on:keypress="is_valid_pin_value($event, 'pin_0')"
                    ref="pin_0"
                    type="text"
                    placeholder="0"
                  />
                  <input
                    :disabled="disable"
                    v-model.number="pin_1"
                    v-on:keyup.left="pin_focus('pin_0')"
                    v-on:keyup.right="pin_focus('pin_2')"
                    v-on:keypress="is_valid_pin_value($event, 'pin_1')"
                    ref="pin_1"
                    type="text"
                    placeholder="0"
                  />

                  <input
                    :disabled="disable"
                    v-model.number="pin_2"
                    v-on:keyup.left="pin_focus('pin_1')"
                    v-on:keyup.right="pin_focus('pin_3')"
                    v-on:keypress="is_valid_pin_value($event, 'pin_2')"
                    ref="pin_2"
                    type="text"
                    placeholder="0"
                  />
                  <input
                    :disabled="disable"
                    v-model.number="pin_3"
                    v-on:keyup.left="pin_focus('pin_2')"
                    v-on:keypress="is_valid_pin_value($event, 'pin_3')"
                    ref="pin_3"
                    type="text"
                    placeholder="0"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="input-group mt-4">
            <button type="button" class="btn btn-primary" @click="addAccount()">
              Create Account
            </button>
            <button
              type="button"
              class="btn btn-danger"
              @click="this.$router.push('/accounts')"
            >
              Cancel
            </button>
            <span :v-if="errMsg" class="w-100 text-danger">{{ errMsg }}</span>
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
  watch: {
    pin: function () {
      this.$bus.$emit("PIN/change", this.pin);
    },
    pin_0: function (nv) {
      if (nv.toString().length !== 0) {
        this.$refs.pin_1.focus();
        this.$refs.pin_1.select();
      }
    },
    pin_1: function (nv) {
      if (nv.toString().length !== 0) {
        this.$refs.pin_2.focus();
        this.$refs.pin_2.select();
      }
    },
    pin_2: function (nv) {
      if (nv.toString().length !== 0) {
        this.$refs.pin_3.focus();
        this.$refs.pin_3.select();
      }
    },
  },
  data() {
    return {
      selected: "current",
      pin_0: null,
      pin_1: null,
      pin_2: null,
      pin_3: null,
      pinfull: null,
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
    pin_focus: function (ref) {
      this.$refs[ref].focus();
      this.$refs[ref].select();
    },
    is_valid_pin_value: function (e, pin_N) {
      const char = String.fromCharCode(e.keyCode);
      const is_value_selected =
        this[pin_N] !== null &&
        this.$refs[pin_N].selectionStart === 0 &&
        this.$refs[pin_N].selectionEnd === this[pin_N].toString().length;
      if (
        (this[pin_N] === null ||
          this[pin_N].toString().length === 0 ||
          is_value_selected) &&
        parseInt(char, 10) >= 0 &&
        parseInt(char, 10) <= 9
      ) {
        return true;
      }

      e.preventDefault();
    },

    isInt: function (evt) {
      evt = evt ? evt : window.event;
      var charCode = evt.which ? evt.which : evt.keyCode;
      if ((charCode = 48 && charCode <= 57)) {
        return true;
      } else {
        evt.preventDefault();
      }
    },
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
      if (
        this.pin_0 != null &&
        this.pin_1 != null &&
        this.pin_2 != null &&
        this.pin_3 != null
      ) {
        const stringCode =
          this.pin_0.toString() +
          this.pin_1.toString() +
          this.pin_2.toString() +
          this.pin_3.toString();
        const data = JSON.stringify({
          accountType: this.selected.valueOf(),
          ownerId: this.ownerId,
          balance: parseFloat(this.balance),
          absLimit: parseFloat(this.abs),
          pinCode: parseInt(stringCode),
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
          .then((response) => {
            console.log(response);
            this.$router.replace("/accounts");
          })
          .catch((error) => {
            console.log(error);
            this.errMsg = "please fill in all the fields.";
          });
      }
    },
  },
};
</script>
