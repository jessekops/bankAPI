<template>
    <section class="table-accounts"></section>
</template>



<script>

import axios from "../../axios-auth";
// import { mapGetters } from "vuex";

export default {
    name: "Index",
    setup() {
        
    },
    data() {
    return {
      accounts: [],
    };
  },
  mounted() {
    axios
    //    .request({
    //         url: 'accounts',
    //         method: 'get',
    //         headers: {
    //             'Authorization': 'Bearer TOKEN'
    //         }
    //    })
      .get("accounts")
      .then((response) => {
        this.accounts = response.data;
        console.log(this.accounts);
      })
      .catch((error) => {
        console.log(error);
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
}
</script>