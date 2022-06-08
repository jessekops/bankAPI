<template :v-if="!isLoggedIn">
  <section class="ftco-section">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-7 col-lg-5">
          <div class="wrap text-center">
            <img class="w-50 mt-4" src="@/assets/inhollandbank.png" />
            <div class="text-muted login-wrap p-2 p-md-2">
              <div class="d-flex">
                <div class="w-100">
                  <h3 class="mb-4">Register an account</h3>
                </div>
              </div>
              <form @submit="checkForm" v-on:submit.prevent="registerUser">
                <div class="form-group mt-3">
                  <label class="form-control-placeholder" for="username"
                    >Username</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    required="required"
                    v-model="username"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="password"
                    >Password</label
                  >
                  <input
                    v-model="password"
                    id="password-field"
                    type="password"
                    class="form-control"
                    required="required"
                  />

                  <span
                    toggle="#password-field"
                    class="fa fa-fw fa-eye field-icon toggle-password"
                  ></span>
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="firstname"
                    >Firstname</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="firstname"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="lastname"
                    >Lastname</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="lastname"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="dob"
                    >Date of birth</label
                  >
                  <Datepicker format="yyyy/MM/dd" v-model="dob"></Datepicker>
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="address"
                    >Address</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="address"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="email"
                    >E-mail</label
                  >
                  <input
                    type="email"
                    class="form-control"
                    v-model="email"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="phone"
                    >Phonenumber</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="phone"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="daylimit"
                    >Daylimit</label
                  >
                  <input
                    @keypress="isNumber($event)"
                    type="text"
                    class="form-control"
                    v-model="dayLimit"
                    required="required"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-placeholder" for="translimit"
                    >Transaction limit</label
                  >
                  <input
                    @keypress="isNumber($event)"
                    type="text"
                    class="form-control"
                    v-model="transLimit"
                    required="required"
                  />
                </div>

                <div class="text-center mt-4 form-group">
                  <button
                    style=""
                    type="submit"
                    class="
                      btn
                      w-100
                      text-center
                      submit
                      vue-butt
                      btn-primary btn-lg
                    "
                  >
                    <span>Register</span>
                  </button>
                  <span> </span>
                  <span :v-if="errorms" class="w-100 text-danger">{{
                    errorms
                  }}</span>
                  <span :v-if="successms" class="w-100 text-success">{{
                    successms
                  }}</span>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "../../axios-auth";
import { mapGetters } from "vuex";
import Datepicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

export default {
  components: { Datepicker },
  name: "Register",
  data() {
    return {
      username: null,
      password: null,
      firstname: null,
      lastname: null,
      dob: null,
      address: null,
      email: null,
      phone: null,
      registeredOn: null,
      active: true,
      dayLimit: 0.0,
      transLimit: 0.0,
      errorms: "",
      successms: "",
    };
  },
  computed: {
    ...mapGetters(["isLoggedIn"]),
    ...mapGetters(["isAdmin"]),
  },

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
    registerUser() {
      let config = {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      };
      var today = new Date();
      const data = JSON.stringify({
        userTypes: ["ROLE_CUSTOMER"],
        username: this.username,
        password: this.password,
        firstname: this.firstname,
        lastname: this.lastname,
        dob: this.dob,
        address: this.address,
        email: this.email,
        phone: this.phone,
        registeredOn: today.toJSON(),
        dayLimit: parseFloat(this.dayLimit),
        transLimit: parseFloat(this.transLimit),
        active: true,
      });
      axios
        .post("users", data, config)
        .then((response) => {
          this.$router.replace("/login");
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.vue-butt {
  display: inline-block;
}
.ftco-section {
  height: 100%;
  background: radial-gradient(
    circle,
    rgb(238, 238, 238) 0%,
    rgb(233, 233, 233)
  );
}
</style>