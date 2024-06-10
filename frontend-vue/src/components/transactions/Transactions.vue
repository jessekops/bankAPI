<template>
  <section class="table-transactions mx-4 p-4">
    <div class="container">
      <div class="button-container p-2 my-2">
        <button @click="this.$router.push('/home')" class="py-2 mx-2 btn btn-danger">
          Go Back
        </button>
      </div>
      <table class="table align-middle mb-0 bg-white shadow-sm">
        <thead class="bg-light">
        <tr>
          <th @click="sortBy('from')">From</th>
          <th @click="sortBy('to')">To</th>
          <th @click="sortBy('amount')">Amount</th>
          <th @click="sortBy('timestamp')">Date</th>
          <th @click="sortBy('transactionType')">Type</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="transaction in sortedTransactions" :key="transaction.id">
          <td>{{ extractIBAN(transaction.from) }}</td>
          <td>{{ transaction.to }}</td>
          <td>€{{ transaction.amount }}</td>
          <td>{{ formatDate(transaction.timestamp) }}</td>
          <td>{{ transaction.transactionType }}</td>
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
  name: "UserTransactions",
  computed: {
    ...mapGetters(["getUserName"]),
    sortedTransactions() {
      return [...this.transactions];
    },
  },
  data() {
    return {
      transactions: [],
      sortKey: '',
      sortOrder: 1,
    };
  },
  methods: {
    formatDate(dateString) {
      const date = new Date(dateString);
      return date.toLocaleString();
    },
    extractIBAN(fromField) {
      const startIndex = fromField.indexOf("iban=") + 5;
      const endIndex = fromField.indexOf(",", startIndex);
      return fromField.substring(startIndex, endIndex);
    },
    sortBy(key) {
      if (this.sortKey === key) {
        this.sortOrder = -this.sortOrder;
      } else {
        this.sortKey = key;
        this.sortOrder = 1;
      }
      this.transactions.sort((a, b) => {
        const x = a[key];
        const y = b[key];
        return this.sortOrder * ((x < y) ? -1 : ((x > y) ? 1 : 0));
      });
    },
  },
  mounted() {
    let token = localStorage.getItem("token");
    axios
        .get(`transactions/user`, {
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          this.transactions = response.data;
        })
        .catch((error) => {
          console.log(error);
          this.errored = true;
        });
  },
};
</script>

<style scoped>
</style>
