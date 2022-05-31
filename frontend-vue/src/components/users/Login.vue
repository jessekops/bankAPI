<template>
  <section class="ftco-section">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-7 col-lg-5">
          <div class="wrap">
            <img class="w-50" src="@/assets/inhollandbank.png" />
            <div class="text-muted login-wrap p-4 p-md-5">
              <div class="d-flex">
                <div class="w-100">
                  <h3 class="mb-4">Sign In</h3>
                </div>
              </div>
              <form v-on:submit.prevent="login">
                <div class="form-group mt-3">
                  <label class="form-control-placeholder" for="username"
                    >Username</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="username"
                    required=""
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
                    required=""
                  />

                  <span
                    toggle="#password-field"
                    class="fa fa-fw fa-eye field-icon toggle-password"
                  ></span>
                </div>
                <div class="text-center mt-4 form-group">
                  <button
                    style=""
                    class="
                      btn
                      w-100
                      text-center
                      submit
                      vue-butt
                      mx-2
                      btn-success btn-lg
                    "
                  >
                    <span>Sign in 🔓</span>
                  </button>
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
export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: "",
    };
  },

  methods: {
    login() {
      this.$store
        .dispatch("login", {
          username: this.username,
          password: this.password,
        })
        .then(() => {
          this.$router.replace("/movies");
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.ftco-section {
  height: 94vh;
  background: radial-gradient(circle, rgb(238, 238, 238) 0%, rgb(233, 233, 233));
}
</style>