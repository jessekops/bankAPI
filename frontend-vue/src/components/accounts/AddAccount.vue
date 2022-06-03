<template>
    <section class="table-accounts mx-4 p-4 ">
        <div class="container">
            <div class="button-container p-2 my-2">            
            <button class="py-2 mx-2 btn btn-danger">Go Back</button>
            <button class="py-2 mx-2 btn btn-primary">Add new Account</button>
        </div>
        <div class="form-container">
            

        <h2 class="mt-3 mt-lg-5 ">Create an Account</h2>
        <h5 class="mb-4"></h5>

        <div class="input-group mb-3">
          <span class="input-group-text">Absolute limit</span>
          <input type="text" class="form-control"  />
        </div>
         <div class="input-group mb-3">
          <span class="input-group-text">Balance</span>
          <input type="text" class="form-control"  />
        </div>
        <div class="input-group mt-4">
          <button type="button" class="btn btn-primary" @click="addAccount()">
            Create Account
          </button>

          <button
            type="button"
            class="btn btn-danger"
            @click="this.$router.push('/')"
          >
            Cancel
          </button>
        </div>




        </div>
</div>
    </section>
</template>

<script>
export default {
    
    name: "AddAccount",
    setup() {
        
    },
    data() {
    return {
    };
  },
}
</script>
