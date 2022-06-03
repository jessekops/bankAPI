<template>
    <section class="table-accounts mx-4 p-4 ">
        <div class="container">
            <div class="button-container p-2 my-2">            
            <button class="py-2 mx-2 btn btn-danger">Go Back</button>
            <button class="py-2 mx-2 btn btn-primary">Add new Account</button>
        </div>
<table class="table align-middle mb-0 bg-white shadow-sm">
  <thead class="bg-light">
    <tr>
      <th>IBan</th>
      <th>AccountType</th>
      <th>ActiveStatus</th>
      <th>Balance</th>
      <th>OwnerID</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="account in accounts" :key="account.id" :account="account">
      <td>
        <div class="d-flex align-items-center">
          <div class="ms-3">
            <p class="text-muted mb-0">{{account.iban}}</p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1">{{account.accountType}}</p>
      </td>
      <td>
        <span class="badge text-primary badge-success rounded-pill d-inline">{{account.active}}</span>
      </td>
      <td>{{account.balance}}</td>
      <td>
       {{account.ownerId}}
      </td>
    </tr>
  </tbody>
</table>
</div>
    </section>
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
    let token = localStorage.getItem('token')
    axios
       .request({
            url: 'accounts',
            method: 'get',
            headers: {
            Accept: 'application/json',
             'Content-Type': 'application/json',
               Authorization: `Bearer ${token}`
            }
       })
      .then((response) => {
        this.accounts = response.data;
      })
      .catch((error) => {
        console.log(error);
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
}
</script>