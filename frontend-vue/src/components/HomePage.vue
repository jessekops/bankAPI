<template>
  <div v-if="isLoggedIn" class="hello">
    <h1>Welkom! je bent ingelogd {{getUserName}}, je rol is: {{getUserRole}}</h1>
  </div>
</template>

<script>

import { mapGetters } from "vuex";


export default {
  name: 'HelloWorld',
    computed: {
    ...mapGetters(["isLoggedIn"]),
    ...mapGetters(["getUserName"]),
    ...mapGetters(["getUserRole"]),
    
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
